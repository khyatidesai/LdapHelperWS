package org.intalio.ldaphelper;

import org.intalio.ldaphelper.Item;
import org.intalio.ldaphelper.LdapHelperSkeleton;
import org.intalio.ldaphelper.Query;
import org.intalio.ldaphelper.QueryResponse;

import junit.framework.TestCase;


public class LdapHelperTest extends TestCase{
    
    public void testquery1() throws java.lang.Exception {
        
        LdapHelperSkeleton  stub = new LdapHelperSkeleton();      
        Query query = (Query) getTestObject(Query.class);
              
        Item[] items = new Item[1];
        items[0] = new Item();
        items[0].setKey("objectClass");
        String[] values = new String[1];
        values[0] = "*";
        items[0].setValue(values);

        String[] returns = { "cn", "uniquemember" };

        query.setParameters(items);
        query.setReturns(returns);
        query.setSearchBase("ou=Roles, dc=examples, dc=com");

        QueryResponse response = stub.query(query);
        System.out.println(response);
        printResponse(response.getResults());
    }

    public void testquery2() throws java.lang.Exception {
        LdapHelperSkeleton stub = new LdapHelperSkeleton();
        Query query = (Query) getTestObject(Query.class);
        Item[] items = new Item[1];
        items[0] = new Item();
        items[0].setKey("mail");
        String[] values = new String[1];
        values[0] = "*intalio*";
        items[0].setValue(values);

        String[] returns = { "cn", "mail", "displayName", "manager" };

        query.setParameters(items);
        query.setReturns(returns);

        QueryResponse response = stub.query(query);
        printResponse(response.getResults());
    }

    public void testupdate() throws java.lang.Exception {
        LdapHelperSkeleton stub = new LdapHelperSkeleton();
        Update update = (Update) getTestObject(Update.class);
        update.setName("cn=bjones, ou=People, dc=examples, dc=com");
        Operation op = new Operation();
        op.setAction(OperationAction.REMOVE);
        Item item = new Item();
        item.setKey("mail");
        op.setItem(item);
        update.setOperation(op);
        UpdateResponse response = stub.update(update);
        printResponse(response.getResults());
        op.setAction(OperationAction.ADD);
        item.setValue(new String[] { "felipe2@intalio.com" });
        response = stub.update(update);
        printResponse(response.getResults());
        op.setAction(OperationAction.REPLACE);
        item.setValue(new String[] { "felipe@intalio.com" });
        response = stub.update(update);
        printResponse(response.getResults());

    }

    private void printResponse(Data[] results) {
        for (int i = 0; i < results.length; i++) {
            Data result = results[i];
            Item[] itms = result.getItems();
            if (itms != null) {
                for (int j = 0; j < itms.length; j++) {
                    if (itms[j].getValue() != null) {
                        for (int k = 0; k < itms[j].getValue().length; k++) {
                            System.out.println(itms[j].getKey() + " - " + itms[j].getValue()[k]);
                        }
                    }
                }
            }
        }
    }

    //Create an ADBBean and provide it as the test object
    public org.apache.axis2.databinding.ADBBean getTestObject(java.lang.Class type) throws java.lang.Exception {
        return (org.apache.axis2.databinding.ADBBean) type.newInstance();
    }
}
