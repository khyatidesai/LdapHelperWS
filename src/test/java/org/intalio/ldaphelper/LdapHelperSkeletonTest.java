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
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.naming.NamingException;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;

import org.apache.log4j.Logger;

import com.unboundid.ldap.sdk.Attribute;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.LDAPResult;
import com.unboundid.ldap.sdk.LDAPSearchException;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchResultEntry;
import com.unboundid.ldap.sdk.SearchScope;
import com.unboundid.ldif.LDIFException;

/**
 * LdapHelperSkeleton java skeleton for the axisService
 */
public class LdapHelperSkeletonTest {

    private LDAPConnection mockConnection;
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
        LdapHelperSkeleton stub = null;

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
            } else {
                prop_providerUrl = "ldap://localhost:10389/";
                prop_securityPrincipal = "uid=admin,ou=system";
                prop_securityCredentials = "secret";
                prop_searchBase = "ou=People,dc=examples,dc=com";

            }
        }
    }

    private void connect() throws NamingException {

        MockLdapServer server = new MockLdapServer();
        mockConnection = server.configureandStartServer();
        System.out.println(mockConnection);
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

    private SearchResult search(String searchBase, String filter, String[] attrReturn) throws IOException, NamingException {

        loadProps();
        connect();
        SearchResult searchResults = null;

        try {
            searchResults = mockConnection.search(searchBase, SearchScope.SUB, filter, attrReturn);
        } catch (LDAPSearchException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return searchResults;
    }

    public QueryResponse query(Query query) throws IOException, NamingException {

        QueryResponse response = new QueryResponse();
        if (query != null) {
            String filter = getFilter(query);
            String[] returns = query.getReturns();
            String[] attrReturn = getReturnAttributes(returns);
            String searchBase = query.getSearchBase();
            SearchResult answer = search(searchBase, filter, attrReturn);

            if (answer != null) {
                List<Data> list = new ArrayList<Data>();

                for (Iterator iterator = answer.getSearchEntries().iterator(); iterator.hasNext();) {

                    List<Item> result_list = new ArrayList<Item>();
                    {
                        SearchResultEntry searchResultEntry = (SearchResultEntry) iterator.next();
                        for (Iterator iterator3 = searchResultEntry.getAttributes().iterator(); iterator3.hasNext();) {
                            int i = 0;
                            Attribute return_attr = (Attribute) iterator3.next();
                            if (return_attr != null) {
                                Item current_result = new Item();
                                current_result.setKey(returns[i]);
                                String[] valuesEnum = return_attr.getValues();
                                List<String> valuesList = new ArrayList<String>();
                                for (int j = 0; j < valuesEnum.length; j++) {
                                    String value = valuesEnum[i];
                                    valuesList.add(value);
                                }

                                current_result.setValue(valuesList.toArray(new String[0]));
                                result_list.add(current_result);
                            }
                            if (result_list.size() > 0) {
                                Data result_item = new Data();
                                result_item.setItems(result_list.toArray(new Item[0]));
                                list.add(result_item);
                            }
                            System.out.println(result_list);
                            i++;

                        }

                    }

                    response.setResults(list.toArray(new Data[0]));
                }

            }
        }
        return response;
    }

    public UpdateResponse update(Update update) throws IOException, NamingException {

        loadProps();
        connect();
        String name = update.getName();

        LDAPResult modifyResult = new LDAPResult(0, null);
        UpdateResponse response = new UpdateResponse();

        OperationAction action = update.getOperation().getAction();
        Item item = update.getOperation().getItem();
        ModificationItem[] mods = new ModificationItem[1];

        try {

            if (action == OperationAction.ADD) {
                mods[0] = new ModificationItem(DirContext.ADD_ATTRIBUTE, new BasicAttribute(item.getKey(),
                        item.getValue()[0]));
                modifyResult = mockConnection
                        .add("dn: cn=kdesai,ou=People,dc=examples,dc=com", "objectClass: organizationalPerson", "objectClass: person", "objectClass: inetOrgPerson", "objectClass: top", "cn: khyati", "departmentnumber: 111", "displayname: Khyati Desai", "givenname: Robert", "l: Foster City", "mail: bjones@intalio.org", "manager: cn=bjones,ou=People,dc=examples,dc=com", "ou: People", "roomnumber: 6733", "sn: Jones", "telephonenumber: (650) 555-9987", "title: Director of Customer Service", "uid: examples\bjones", "userpassword:: cGFzc3dvcmQ=");
            } else {
                if (action == OperationAction.REMOVE) {
                    mods[0] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE, new BasicAttribute(item.getKey()));

                } else {
                    if (action == OperationAction.REPLACE) {
                        mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute(item.getKey(),
                                item.getValue()[0]));
                        modifyResult = mockConnection
                                .modify("dn: cn=msmith,ou=People,dc=examples,dc=com", "changetype: modify", "replace:mail", "mail:marksmith@intalio.com");
                    }
                }
            }
            System.out.println(modifyResult.getMatchedDN());

            SearchResultEntry entries = mockConnection.getEntry(prop_searchBase, "mail:khyati@intalio.com");
            Data[] results = new Data[1];
            results[0] = new Data();

            Item[] results_item = new Item[1];
            results_item[0] = new Item();
            results_item[0].setKey(item.getKey());
            if (action != OperationAction.REMOVE) {
                List<String> valuesList = new ArrayList<String>();

                for (Iterator iterator = entries.getAttributes().iterator(); iterator.hasNext();) {

                    Attribute return_attr = (Attribute) iterator.next();
                    String[] valuesEnum = return_attr.getValues();
                    for (int j = 0; j < valuesEnum.length; j++) {
                        String value = valuesEnum[j];
                        valuesList.add(value);
                    }

                }

                results_item[0].setValue(valuesList.toArray(new String[0]));
            }
            results[0].setItems(results_item);

            response.setResults(results);

        } catch (LDIFException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (LDAPException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return response;
    }

}
