/**
 * LdapHelperSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.6  Built on : Aug 30, 2011 (10:00:16 CEST)
 */
package org.intalio.ldaphelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.apache.log4j.Logger;

/**
 * LdapHelperSkeleton java skeleton for the axisService
 */
public class LdapHelperSkeleton {

    private InitialDirContext ctx;
    private String prop_providerUrl;
    private String prop_securityPrincipal;
    private String prop_securityCredentials;
    private String prop_searchBase;
    private static final String CONFIG_FILE_NAME = "ldapQuery.properties";
    private static final String CONFIG_DIR = "org.intalio.deploy.configDirectory";
    private static final Logger LOG = Logger.getLogger(LdapHelperSkeleton.class);

    private void loadProps() throws IOException {

        File cfgFile = new File(System.getProperty(CONFIG_DIR) + File.separator + CONFIG_FILE_NAME);
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(cfgFile);
            Properties props = new Properties();
            if (fis != null) {
                props.load(fis);
                prop_providerUrl = props.getProperty("url");

                prop_securityPrincipal = props.getProperty("principal");
                prop_securityCredentials = props.getProperty("credentials");

                prop_searchBase = props.getProperty("search_base");

            }

        } catch (FileNotFoundException e) {
            LOG.error("config file does not exists: " + e);
        } catch (IOException e) {
            LOG.warn("Exception is: " + e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    LOG.warn("Exception is: " + e);
                }
            }else{
                prop_providerUrl = "ldap://localhost:10389/";
                prop_securityPrincipal = "uid=admin,ou=system";
                prop_securityCredentials = "secret";
                prop_searchBase = "ou=People,dc=examples,dc=com";
                
            }
        }
    }

    private void connect() throws NamingException {

        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, prop_providerUrl);
        env.put(Context.SECURITY_PRINCIPAL, prop_securityPrincipal);
        env.put(Context.SECURITY_CREDENTIALS, prop_securityCredentials);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");

        ctx = new InitialDirContext(env);
    }

    private String sanatize(String input) {
        String s = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (i > 0 && i < input.length() - 1 && c == '*') {
                s += "\\2a";
            } else if (c == '(') {
                // escape left parenthesis
                s += "\\28";
            } else if (c == ')') {
                // escape right parenthesis
                s += "\\29";
            } else if (c == '\\') {
                // escape backslash
                s += "\\5c";
            } else if (c == '\u0000') {
                // escape NULL char
                s += "\\00";
            } else if (c <= 0x7f) {
                // regular 1-byte UTF-8 char
                s += String.valueOf(c);
            } else if (c >= 0x080) {

                // higher-order 2, 3 and 4-byte UTF-8 chars

                try {
                    byte[] utf8bytes = String.valueOf(c).getBytes("UTF8");

                    for (byte b : utf8bytes)
                        s += String.format("\\%02x", b);

                } catch (UnsupportedEncodingException e) {
                    // ignore
                }
            }
        }
        return s;
    }

    private String getFilter(Query query) {
        Item[] params = query.getParameters();
        StringBuilder filterString = new StringBuilder();
        for (int i = 0; i < params.length; i++) {
            filterString.append("(" + params[i].getKey() + "=" + sanatize(params[i].getValue()[0]) + ")");
        }
        if (params.length > 1) {
            filterString.insert(0, "(&");
            filterString.append(")");
        }
        return filterString.toString();

    }

    private String[] getReturnAttributes(String[] returns) {
        String[] attrReturn = new String[returns.length];
        for (int i = 0; i < returns.length; i++) {
            attrReturn[i] = returns[i];
        }
        return attrReturn;
    }

    private NamingEnumeration search(String searchBase, String filter, String[] attrReturn) throws IOException, NamingException {
        loadProps();
        connect();
        SearchControls ctls = new SearchControls();
        ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        ctls.setReturningAttributes(attrReturn);
        if (searchBase == null) {
            searchBase = prop_searchBase;
        }
        return ctx.search(searchBase, filter, ctls);
    }

    public QueryResponse query(Query query) throws IOException, NamingException {

        QueryResponse response = new QueryResponse();
        if (query != null) {
            String filter = getFilter(query);
            String[] returns = query.getReturns();
            String[] attrReturn = getReturnAttributes(returns);
            String searchBase = query.getSearchBase();
            NamingEnumeration answer = search(searchBase, filter, attrReturn);

            if (answer != null) {
                List<Data> list = new ArrayList<Data>();
                while (answer.hasMoreElements()) {
                    List<Item> result_list = new ArrayList<Item>();
                    SearchResult current = (SearchResult) answer.nextElement();
                    Attributes attr = current.getAttributes();
                    for (int i = 0; i < returns.length; i++) {
                        Attribute return_attr = attr.get(returns[i]);
                        if (return_attr != null) {
                            Item current_result = new Item();
                            current_result.setKey(returns[i]);
                            NamingEnumeration valuesEnum = return_attr.getAll();
                            List<String> valuesList = new ArrayList<String>();
                            while (valuesEnum.hasMore()) {
                                String value = (String) valuesEnum.next();
                                valuesList.add(value);
                            }
                            current_result.setValue(valuesList.toArray(new String[0]));
                            result_list.add(current_result);
                        }
                    }
                    if (result_list.size() > 0) {
                        Data result_item = new Data();
                        result_item.setItems(result_list.toArray(new Item[0]));
                        list.add(result_item);
                    }
                }
                response.setResults(list.toArray(new Data[0]));
            }

        }
        return response;
    }

    public UpdateResponse update(Update update) throws IOException, NamingException {
        loadProps();
        connect();
        String name = update.getName();
        OperationAction action = update.getOperation().getAction();
        Item item = update.getOperation().getItem();
        ModificationItem[] mods = new ModificationItem[1];
        if (action == OperationAction.ADD) {
            mods[0] = new ModificationItem(DirContext.ADD_ATTRIBUTE, new BasicAttribute(item.getKey(),
                    item.getValue()[0]));
        } else {
            if (action == OperationAction.REMOVE) {
                mods[0] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE, new BasicAttribute(item.getKey()));
            } else {
                if (action == OperationAction.REPLACE) {
                    mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute(item.getKey(),
                            item.getValue()[0]));
                }
            }
        }
        ctx.modifyAttributes(name, mods);
        Attributes attrs = ctx.getAttributes(name, new String[] { item.getKey() });
        Attribute attr = attrs.get(item.getKey());

        Data[] results = new Data[1];
        results[0] = new Data();

        Item[] results_item = new Item[1];
        results_item[0] = new Item();
        results_item[0].setKey(item.getKey());
        if (action != OperationAction.REMOVE) {
            NamingEnumeration valuesEnum = attr.getAll();
            List<String> valuesList = new ArrayList<String>();
            while (valuesEnum.hasMore()) {
                String value = (String) valuesEnum.next();
                valuesList.add(value);
            }
            results_item[0].setValue(valuesList.toArray(new String[0]));
        }
        results[0].setItems(results_item);
        UpdateResponse response = new UpdateResponse();
        response.setResults(results);
        return response;
    }
}
