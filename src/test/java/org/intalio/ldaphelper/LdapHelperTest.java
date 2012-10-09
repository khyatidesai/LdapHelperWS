package org.intalio.ldaphelper;

import junit.framework.TestCase;

public class LdapHelperTest extends TestCase {

    public void testquery1() throws java.lang.Exception {

        LdapHelperSkeletonTest stub = new LdapHelperSkeletonTest();
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
        query.setSearchBase("ou=People, dc=examples, dc=com");

        QueryResponse response = stub.query(query);
        System.out.println(response);
        printResponse(response.getResults());
    }

    public void testquery2() throws java.lang.Exception {

        LdapHelperSkeletonTest stub = new LdapHelperSkeletonTest();
        Query query = (Query) getTestObject(Query.class);
        Item[] items = new Item[1];
        items[0] = new Item();
        items[0].setKey("mail");
        String[] values = new String[1];
        values[0] = "*intalio*";
        items[0].setValue(values);

        String[] returns = { "cn", "mail", "displayName", "manager" };

        query.setSearchBase("ou=People, dc=examples, dc=com");
        query.setParameters(items);
        query.setReturns(returns);

        QueryResponse response = stub.query(query);
        printResponse(response.getResults());
    }

    public void testupdate() throws java.lang.Exception {

        LdapHelperSkeletonTest stub = new LdapHelperSkeletonTest();
        Update update = (Update) getTestObject(Update.class);
        String[] addRecord = {"dn: cn=kdesai,ou=People,dc=examples,dc=com", "objectClass: organizationalPerson", "objectClass: person", "objectClass: inetOrgPerson", "objectClass: top", "cn: khyati", "departmentnumber: 111", "displayname: Khyati Desai", "givenname: Robert", "l: Foster City", "mail: bjones@intalio.org", "manager: cn=bjones,ou=People,dc=examples,dc=com", "ou: People", "roomnumber: 6733", "sn: Jones", "telephonenumber: (650) 555-9987", "title: Director of Customer Service", "uid: examples\bjones", "userpassword:: cGFzc3dvcmQ="};
        update.setNames(addRecord);

        Operation op = new Operation();
        Item item = new Item();
        item.setKey("mail");
        op.setItem(item);
        op.setAction(OperationAction.ADD);
        item.setValue(new String[] { "khyati@intalio.com" });
        update.setOperation(op);
        UpdateResponse response = stub.update(update);
        printResponse(response.getResults());

        update.setNames(new String[]{"dn: cn=msmith,ou=People,dc=examples,dc=com", "changetype: modify", "replace:mail", "mail:marksmith@intalio.com"});
        op.setAction(OperationAction.REPLACE);
        item.setValue(new String[] { "mail:marksmith@intalio.com" });
        update.setOperation(op);
        response = stub.update(update);
        printResponse(response.getResults());

        op.setAction(OperationAction.REMOVE);
        update.setOperation(op);
        update.setOperation(op);
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
