/**
 * Query.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.6  Built on : Aug 30, 2011 (10:01:01 CEST)
 */

package org.intalio.ldaphelper;

/**
 * Query bean class
 */

public class Query implements org.apache.axis2.databinding.ADBBean {

	/**
				 * 
				 */
	private static final long serialVersionUID = 1L;

	public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
			"http://bpms.intalio.org/LdapHelper/", "Query", "ns1");

	private static java.lang.String generatePrefix(java.lang.String namespace) {
		if (namespace.equals("http://bpms.intalio.org/LdapHelper/")) {
			return "ns1";
		}
		return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
	}

	/**
	 * field for SearchBase
	 */

	protected java.lang.String localSearchBase;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localSearchBaseTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getSearchBase() {
		return localSearchBase;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            SearchBase
	 */
	public void setSearchBase(java.lang.String param) {

		if (param != null) {
			// update the setting tracker
			localSearchBaseTracker = true;
		} else {
			localSearchBaseTracker = false;

		}

		this.localSearchBase = param;

	}

	/**
	 * field for Parameters This was an Array!
	 */

	protected org.intalio.ldaphelper.Item[] localParameters;

	/**
	 * Auto generated getter method
	 * 
	 * @return org.intalio.ldaphelper.Item[]
	 */
	public org.intalio.ldaphelper.Item[] getParameters() {
		return localParameters;
	}

	/**
	 * validate the array for Parameters
	 */
	protected void validateParameters(org.intalio.ldaphelper.Item[] param) {

		if ((param != null) && (param.length < 1)) {
			throw new java.lang.RuntimeException();
		}

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            Parameters
	 */
	public void setParameters(org.intalio.ldaphelper.Item[] param) {

		validateParameters(param);

		this.localParameters = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param
	 *            org.intalio.ldaphelper.Item
	 */
	public void addParameters(org.intalio.ldaphelper.Item param) {
		if (localParameters == null) {
			localParameters = new org.intalio.ldaphelper.Item[] {};
		}

		java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
				.toList(localParameters);
		list.add(param);
		this.localParameters = (org.intalio.ldaphelper.Item[]) list
				.toArray(new org.intalio.ldaphelper.Item[list.size()]);

	}

	/**
	 * field for Returns This was an Array!
	 */

	protected java.lang.String[] localReturns;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String[]
	 */
	public java.lang.String[] getReturns() {
		return localReturns;
	}

	/**
	 * validate the array for Returns
	 */
	protected void validateReturns(java.lang.String[] param) {

		if ((param != null) && (param.length < 1)) {
			throw new java.lang.RuntimeException();
		}

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            Returns
	 */
	public void setReturns(java.lang.String[] param) {

		validateReturns(param);

		this.localReturns = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param
	 *            java.lang.String
	 */
	public void addReturns(java.lang.String param) {
		if (localReturns == null) {
			localReturns = new java.lang.String[] {};
		}

		java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
				.toList(localReturns);
		list.add(param);
		this.localReturns = (java.lang.String[]) list
				.toArray(new java.lang.String[list.size()]);

	}

	/**
	 * isReaderMTOMAware
	 * 
	 * @return true if the reader supports MTOM
	 */
	public static boolean isReaderMTOMAware(
			javax.xml.stream.XMLStreamReader reader) {
		boolean isReaderMTOMAware = false;

		try {
			isReaderMTOMAware = java.lang.Boolean.TRUE
					.equals(reader
							.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
		} catch (java.lang.IllegalArgumentException e) {
			isReaderMTOMAware = false;
		}
		return isReaderMTOMAware;
	}

	/**
	 * 
	 * @param parentQName
	 * @param factory
	 * @return org.apache.axiom.om.OMElement
	 */
	public org.apache.axiom.om.OMElement getOMElement(
			final javax.xml.namespace.QName parentQName,
			final org.apache.axiom.om.OMFactory factory)
			throws org.apache.axis2.databinding.ADBException {

		org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
				this, MY_QNAME) {

			public void serialize(
					org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
					throws javax.xml.stream.XMLStreamException {
				Query.this.serialize(MY_QNAME, factory, xmlWriter);
			}
		};
		return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME,
				factory, dataSource);

	}

	public void serialize(
			final javax.xml.namespace.QName parentQName,
			final org.apache.axiom.om.OMFactory factory,
			org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException,
			org.apache.axis2.databinding.ADBException {
		serialize(parentQName, factory, xmlWriter, false);
	}

	public void serialize(
			final javax.xml.namespace.QName parentQName,
			final org.apache.axiom.om.OMFactory factory,
			org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
			boolean serializeType) throws javax.xml.stream.XMLStreamException,
			org.apache.axis2.databinding.ADBException {

		java.lang.String prefix = null;
		java.lang.String namespace = null;

		prefix = parentQName.getPrefix();
		namespace = parentQName.getNamespaceURI();

		if ((namespace != null) && (namespace.trim().length() > 0)) {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace,
						parentQName.getLocalPart());
			} else {
				if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(),
						namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		} else {
			xmlWriter.writeStartElement(parentQName.getLocalPart());
		}

		if (serializeType) {

			java.lang.String namespacePrefix = registerPrefix(xmlWriter,
					"http://bpms.intalio.org/LdapHelper/");
			if ((namespacePrefix != null)
					&& (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						namespacePrefix + ":Query", xmlWriter);
			} else {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						"Query", xmlWriter);
			}

		}
		if (localSearchBaseTracker) {
			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter
							.writeStartElement(prefix, "searchBase", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "searchBase");
				}

			} else {
				xmlWriter.writeStartElement("searchBase");
			}

			if (localSearchBase == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"searchBase cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localSearchBase);

			}

			xmlWriter.writeEndElement();
		}
		if (localParameters != null) {
			for (int i = 0; i < localParameters.length; i++) {
				if (localParameters[i] != null) {
					localParameters[i].serialize(new javax.xml.namespace.QName(
							"", "Parameters"), factory, xmlWriter);
				} else {

					throw new org.apache.axis2.databinding.ADBException(
							"Parameters cannot be null!!");

				}

			}
		} else {

			throw new org.apache.axis2.databinding.ADBException(
					"Parameters cannot be null!!");

		}

		if (localReturns != null) {
			namespace = "";
			boolean emptyNamespace = namespace == null
					|| namespace.length() == 0;
			prefix = emptyNamespace ? null : xmlWriter.getPrefix(namespace);
			for (int i = 0; i < localReturns.length; i++) {

				if (localReturns[i] != null) {

					if (!emptyNamespace) {
						if (prefix == null) {
							java.lang.String prefix2 = generatePrefix(namespace);

							xmlWriter.writeStartElement(prefix2, "Returns",
									namespace);
							xmlWriter.writeNamespace(prefix2, namespace);
							xmlWriter.setPrefix(prefix2, namespace);

						} else {
							xmlWriter.writeStartElement(namespace, "Returns");
						}

					} else {
						xmlWriter.writeStartElement("Returns");
					}

					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localReturns[i]));

					xmlWriter.writeEndElement();

				} else {

					throw new org.apache.axis2.databinding.ADBException(
							"Returns cannot be null!!");

				}

			}
		} else {

			throw new org.apache.axis2.databinding.ADBException(
					"Returns cannot be null!!");

		}

		xmlWriter.writeEndElement();

	}

	/**
	 * Util method to write an attribute with the ns prefix
	 */
	private void writeAttribute(java.lang.String prefix,
			java.lang.String namespace, java.lang.String attName,
			java.lang.String attValue,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {
		if (xmlWriter.getPrefix(namespace) == null) {
			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);

		}

		xmlWriter.writeAttribute(namespace, attName, attValue);

	}

	/**
	 * Util method to write an attribute without the ns prefix
	 */
	private void writeAttribute(java.lang.String namespace,
			java.lang.String attName, java.lang.String attValue,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {
		if (namespace.equals("")) {
			xmlWriter.writeAttribute(attName, attValue);
		} else {
			registerPrefix(xmlWriter, namespace);
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}
	}

	/**
	 * Util method to write an attribute without the ns prefix
	 */
	private void writeQNameAttribute(java.lang.String namespace,
			java.lang.String attName, javax.xml.namespace.QName qname,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {

		java.lang.String attributeNamespace = qname.getNamespaceURI();
		java.lang.String attributePrefix = xmlWriter
				.getPrefix(attributeNamespace);
		if (attributePrefix == null) {
			attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
		}
		java.lang.String attributeValue;
		if (attributePrefix.trim().length() > 0) {
			attributeValue = attributePrefix + ":" + qname.getLocalPart();
		} else {
			attributeValue = qname.getLocalPart();
		}

		if (namespace.equals("")) {
			xmlWriter.writeAttribute(attName, attributeValue);
		} else {
			registerPrefix(xmlWriter, namespace);
			xmlWriter.writeAttribute(namespace, attName, attributeValue);
		}
	}

	/**
	 * method to handle Qnames
	 */

	private void writeQName(javax.xml.namespace.QName qname,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {
		java.lang.String namespaceURI = qname.getNamespaceURI();
		if (namespaceURI != null) {
			java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
			if (prefix == null) {
				prefix = generatePrefix(namespaceURI);
				xmlWriter.writeNamespace(prefix, namespaceURI);
				xmlWriter.setPrefix(prefix, namespaceURI);
			}

			if (prefix.trim().length() > 0) {
				xmlWriter.writeCharacters(prefix
						+ ":"
						+ org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			} else {
				// i.e this is the default namespace
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}

		} else {
			xmlWriter
					.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(qname));
		}
	}

	private void writeQNames(javax.xml.namespace.QName[] qnames,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {

		if (qnames != null) {
			// we have to store this data until last moment since it is not
			// possible to write any
			// namespace data after writing the charactor data
			java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
			java.lang.String namespaceURI = null;
			java.lang.String prefix = null;

			for (int i = 0; i < qnames.length; i++) {
				if (i > 0) {
					stringToWrite.append(" ");
				}
				namespaceURI = qnames[i].getNamespaceURI();
				if (namespaceURI != null) {
					prefix = xmlWriter.getPrefix(namespaceURI);
					if ((prefix == null) || (prefix.length() == 0)) {
						prefix = generatePrefix(namespaceURI);
						xmlWriter.writeNamespace(prefix, namespaceURI);
						xmlWriter.setPrefix(prefix, namespaceURI);
					}

					if (prefix.trim().length() > 0) {
						stringToWrite
								.append(prefix)
								.append(":")
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				} else {
					stringToWrite
							.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
				}
			}
			xmlWriter.writeCharacters(stringToWrite.toString());
		}

	}

	/**
	 * Register a namespace prefix
	 */
	private java.lang.String registerPrefix(
			javax.xml.stream.XMLStreamWriter xmlWriter,
			java.lang.String namespace)
			throws javax.xml.stream.XMLStreamException {
		java.lang.String prefix = xmlWriter.getPrefix(namespace);

		if (prefix == null) {
			prefix = generatePrefix(namespace);

			while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
				prefix = org.apache.axis2.databinding.utils.BeanUtil
						.getUniquePrefix();
			}

			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);
		}

		return prefix;
	}

	/**
	 * databinding method to get an XML representation of this object
	 * 
	 */
	public javax.xml.stream.XMLStreamReader getPullParser(
			javax.xml.namespace.QName qName)
			throws org.apache.axis2.databinding.ADBException {

		java.util.ArrayList elementList = new java.util.ArrayList();
		java.util.ArrayList attribList = new java.util.ArrayList();

		if (localSearchBaseTracker) {
			elementList.add(new javax.xml.namespace.QName("", "searchBase"));

			if (localSearchBase != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localSearchBase));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"searchBase cannot be null!!");
			}
		}
		if (localParameters != null) {
			for (int i = 0; i < localParameters.length; i++) {

				if (localParameters[i] != null) {
					elementList.add(new javax.xml.namespace.QName("",
							"Parameters"));
					elementList.add(localParameters[i]);
				} else {

					throw new org.apache.axis2.databinding.ADBException(
							"Parameters cannot be null !!");

				}

			}
		} else {

			throw new org.apache.axis2.databinding.ADBException(
					"Parameters cannot be null!!");

		}

		if (localReturns != null) {
			for (int i = 0; i < localReturns.length; i++) {

				if (localReturns[i] != null) {
					elementList
							.add(new javax.xml.namespace.QName("", "Returns"));
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localReturns[i]));
				} else {

					throw new org.apache.axis2.databinding.ADBException(
							"Returns cannot be null!!");

				}

			}
		} else {

			throw new org.apache.axis2.databinding.ADBException(
					"Returns cannot be null!!");

		}

		return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
				qName, elementList.toArray(), attribList.toArray());

	}

	/**
	 * Factory class that keeps the parse method
	 */
	public static class Factory {

		/**
		 * static method to create the object Precondition: If this object is an
		 * element, the current or next start element starts this object and any
		 * intervening reader events are ignorable If this object is not an
		 * element, it is a complex type and the reader is at the event just
		 * after the outer start element Postcondition: If this object is an
		 * element, the reader is positioned at its end element If this object
		 * is a complex type, the reader is positioned at the end element of its
		 * outer element
		 */
		public static Query parse(javax.xml.stream.XMLStreamReader reader)
				throws java.lang.Exception {
			Query object = new Query();

			int event;
			java.lang.String nillableValue = null;
			java.lang.String prefix = "";
			java.lang.String namespaceuri = "";
			try {

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.getAttributeValue(
						"http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
					java.lang.String fullTypeName = reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type");
					if (fullTypeName != null) {
						java.lang.String nsPrefix = null;
						if (fullTypeName.indexOf(":") > -1) {
							nsPrefix = fullTypeName.substring(0,
									fullTypeName.indexOf(":"));
						}
						nsPrefix = nsPrefix == null ? "" : nsPrefix;

						java.lang.String type = fullTypeName
								.substring(fullTypeName.indexOf(":") + 1);

						if (!"Query".equals(type)) {
							// find namespace for the prefix
							java.lang.String nsUri = reader
									.getNamespaceContext().getNamespaceURI(
											nsPrefix);
							return (Query) org.intalio.ldaphelper.ExtensionMapper
									.getTypeObject(nsUri, type, reader);
						}

					}

				}

				// Note all attributes that were handled. Used to differ normal
				// attributes
				// from anyAttributes.
				java.util.Vector handledAttributes = new java.util.Vector();

				reader.next();

				java.util.ArrayList list2 = new java.util.ArrayList();

				java.util.ArrayList list3 = new java.util.ArrayList();

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("", "searchBase")
								.equals(reader.getName())) {

					java.lang.String content = reader.getElementText();

					object.setSearchBase(org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("", "Parameters")
								.equals(reader.getName())) {

					// Process the array and step past its final element's end.
					list2.add(org.intalio.ldaphelper.Item.Factory.parse(reader));

					// loop until we find a start element that is not part of
					// this array
					boolean loopDone2 = false;
					while (!loopDone2) {
						// We should be at the end element, but make sure
						while (!reader.isEndElement())
							reader.next();
						// Step out of this element
						reader.next();
						// Step to next element event.
						while (!reader.isStartElement()
								&& !reader.isEndElement())
							reader.next();
						if (reader.isEndElement()) {
							// two continuous end elements means we are exiting
							// the xml structure
							loopDone2 = true;
						} else {
							if (new javax.xml.namespace.QName("", "Parameters")
									.equals(reader.getName())) {
								list2.add(org.intalio.ldaphelper.Item.Factory
										.parse(reader));

							} else {
								loopDone2 = true;
							}
						}
					}
					// call the converter utility to convert and set the array

					object.setParameters((org.intalio.ldaphelper.Item[]) org.apache.axis2.databinding.utils.ConverterUtil
							.convertToArray(org.intalio.ldaphelper.Item.class,
									list2));

				} // End of if for expected property start element

				else {
					// A start element we are not expecting indicates an invalid
					// parameter was passed
					throw new org.apache.axis2.databinding.ADBException(
							"Unexpected subelement " + reader.getLocalName());
				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName("", "Returns")
								.equals(reader.getName())) {

					// Process the array and step past its final element's end.
					list3.add(reader.getElementText());

					// loop until we find a start element that is not part of
					// this array
					boolean loopDone3 = false;
					while (!loopDone3) {
						// Ensure we are at the EndElement
						while (!reader.isEndElement()) {
							reader.next();
						}
						// Step out of this element
						reader.next();
						// Step to next element event.
						while (!reader.isStartElement()
								&& !reader.isEndElement())
							reader.next();
						if (reader.isEndElement()) {
							// two continuous end elements means we are exiting
							// the xml structure
							loopDone3 = true;
						} else {
							if (new javax.xml.namespace.QName("", "Returns")
									.equals(reader.getName())) {
								list3.add(reader.getElementText());

							} else {
								loopDone3 = true;
							}
						}
					}
					// call the converter utility to convert and set the array

					object.setReturns((java.lang.String[]) list3
							.toArray(new java.lang.String[list3.size()]));

				} // End of if for expected property start element

				else {
					// A start element we are not expecting indicates an invalid
					// parameter was passed
					throw new org.apache.axis2.databinding.ADBException(
							"Unexpected subelement " + reader.getLocalName());
				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement())
					// A start element we are not expecting indicates a trailing
					// invalid property
					throw new org.apache.axis2.databinding.ADBException(
							"Unexpected subelement " + reader.getLocalName());

			} catch (javax.xml.stream.XMLStreamException e) {
				throw new java.lang.Exception(e);
			}

			return object;
		}

	}// end of factory class

}
