/**
 * LdapHelperMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.6  Built on : Aug 30, 2011 (10:00:16 CEST)
 */
package org.intalio.ldaphelper;

/**
 * LdapHelperMessageReceiverInOut message receiver
 */

public class LdapHelperMessageReceiverInOut extends
		org.apache.axis2.receivers.AbstractInOutMessageReceiver {

	public void invokeBusinessLogic(
			org.apache.axis2.context.MessageContext msgContext,
			org.apache.axis2.context.MessageContext newMsgContext)
			throws org.apache.axis2.AxisFault {

		try {

			// get the implementation class for the Web Service
			Object obj = getTheImplementationObject(msgContext);

			LdapHelperSkeleton skel = (LdapHelperSkeleton) obj;
			// Out Envelop
			org.apache.axiom.soap.SOAPEnvelope envelope = null;
			// Find the axisOperation that has been set by the Dispatch phase.
			org.apache.axis2.description.AxisOperation op = msgContext
					.getOperationContext().getAxisOperation();
			if (op == null) {
				throw new org.apache.axis2.AxisFault(
						"Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
			}

			java.lang.String methodName;
			if ((op.getName() != null)
					&& ((methodName = org.apache.axis2.util.JavaUtils
							.xmlNameToJavaIdentifier(op.getName()
									.getLocalPart())) != null)) {

				if ("update".equals(methodName)) {

					org.intalio.ldaphelper.UpdateResponse updateResponse1 = null;
					org.intalio.ldaphelper.Update wrappedParam = (org.intalio.ldaphelper.Update) fromOM(
							msgContext.getEnvelope().getBody()
									.getFirstElement(),
							org.intalio.ldaphelper.Update.class,
							getEnvelopeNamespaces(msgContext.getEnvelope()));

					updateResponse1 =

					skel.update(wrappedParam);

					envelope = toEnvelope(getSOAPFactory(msgContext),
							updateResponse1, false);
				} else

				if ("query".equals(methodName)) {

					org.intalio.ldaphelper.QueryResponse queryResponse3 = null;
					org.intalio.ldaphelper.Query wrappedParam = (org.intalio.ldaphelper.Query) fromOM(
							msgContext.getEnvelope().getBody()
									.getFirstElement(),
							org.intalio.ldaphelper.Query.class,
							getEnvelopeNamespaces(msgContext.getEnvelope()));

					queryResponse3 =

					skel.query(wrappedParam);

					envelope = toEnvelope(getSOAPFactory(msgContext),
							queryResponse3, false);

				} else {
					throw new java.lang.RuntimeException("method not found");
				}

				newMsgContext.setEnvelope(envelope);
			}
		} catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	//
	private org.apache.axiom.om.OMElement toOM(
			org.intalio.ldaphelper.Update param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(org.intalio.ldaphelper.Update.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			org.intalio.ldaphelper.UpdateResponse param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(
					org.intalio.ldaphelper.UpdateResponse.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			org.intalio.ldaphelper.Query param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(org.intalio.ldaphelper.Query.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			org.intalio.ldaphelper.QueryResponse param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(
					org.intalio.ldaphelper.QueryResponse.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory,
			org.intalio.ldaphelper.UpdateResponse param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {
		try {
			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
					.getDefaultEnvelope();

			emptyEnvelope.getBody().addChild(
					param.getOMElement(
							org.intalio.ldaphelper.UpdateResponse.MY_QNAME,
							factory));

			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private org.intalio.ldaphelper.UpdateResponse wrapUpdate() {
		org.intalio.ldaphelper.UpdateResponse wrappedElement = new org.intalio.ldaphelper.UpdateResponse();
		return wrappedElement;
	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory,
			org.intalio.ldaphelper.QueryResponse param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {
		try {
			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
					.getDefaultEnvelope();

			emptyEnvelope.getBody().addChild(
					param.getOMElement(
							org.intalio.ldaphelper.QueryResponse.MY_QNAME,
							factory));

			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private org.intalio.ldaphelper.QueryResponse wrapQuery() {
		org.intalio.ldaphelper.QueryResponse wrappedElement = new org.intalio.ldaphelper.QueryResponse();
		return wrappedElement;
	}

	/**
	 * get the default envelope
	 */
	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory) {
		return factory.getDefaultEnvelope();
	}

	private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
			java.lang.Class type, java.util.Map extraNamespaces)
			throws org.apache.axis2.AxisFault {

		try {

			if (org.intalio.ldaphelper.Update.class.equals(type)) {

				return org.intalio.ldaphelper.Update.Factory.parse(param
						.getXMLStreamReaderWithoutCaching());

			}

			if (org.intalio.ldaphelper.UpdateResponse.class.equals(type)) {

				return org.intalio.ldaphelper.UpdateResponse.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (org.intalio.ldaphelper.Query.class.equals(type)) {

				return org.intalio.ldaphelper.Query.Factory.parse(param
						.getXMLStreamReaderWithoutCaching());

			}

			if (org.intalio.ldaphelper.QueryResponse.class.equals(type)) {

				return org.intalio.ldaphelper.QueryResponse.Factory.parse(param
						.getXMLStreamReaderWithoutCaching());

			}

		} catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
		return null;
	}

	/**
	 * A utility method that copies the namepaces from the SOAPEnvelope
	 */
	private java.util.Map getEnvelopeNamespaces(
			org.apache.axiom.soap.SOAPEnvelope env) {
		java.util.Map returnMap = new java.util.HashMap();
		java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
		while (namespaceIterator.hasNext()) {
			org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator
					.next();
			returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
		}
		return returnMap;
	}

	private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
		org.apache.axis2.AxisFault f;
		Throwable cause = e.getCause();
		if (cause != null) {
			f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
		} else {
			f = new org.apache.axis2.AxisFault(e.getMessage());
		}

		return f;
	}

}// end of class
