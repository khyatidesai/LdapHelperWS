APACHE_COMMONS = {
  :beanutils => "commons-beanutils:commons-beanutils:jar:1.7.0",
  :cli => "commons-cli:commons-cli:jar:1.1",
  :codec => "commons-codec:commons-codec:jar:1.3",
  :collections => "commons-collections:commons-collections:jar:3.2", 
  :daemon => "commons-daemon:commons-daemon:jar:1.0.1", 
  :dbcp => "commons-dbcp:commons-dbcp:jar:1.2.2",
  :digester => "commons-digester:commons-digester:jar:1.7",
  :discovery => "commons-discovery:commons-discovery:jar:0.2",
  :fileupload => "commons-fileupload:commons-fileupload:jar:1.2.1",
  :httpclient => "commons-httpclient:commons-httpclient:jar:3.1",
  :io => "commons-io:commons-io:jar:1.2",
  :lang => "commons-lang:commons-lang:jar:2.3",
  :logging => "commons-logging:commons-logging:jar:1.0.4",
  :pool => "commons-pool:commons-pool:jar:1.4",
  :validator => "commons-validator:commons-validator:jar:1.2.0"
}

JASYPT = "org.jasypt:jasypt:jar:1.8"

AXIOM = group("axiom-api", "axiom-dom", "axiom-impl", :under=>"org.apache.ws.commons.axiom", :version=>"1.2.11")

BACKPORT = "backport-util-concurrent:backport-util-concurrent:jar:3.1"


DSIG = "javax.xml.xmldsig:xmldsig:jar:1.0"
DOM4J = "dom4j:dom4j:jar:1.6.1"

JAXEN = "jaxen:jaxen:jar:1.1.1"
JDOM = "jdom:jdom:jar:1.0"
JUNIT = "junit:junit:jar:4.4"

LOG4J = "log4j:log4j:jar:1.2.15"

NEETHI = "org.apache.neethi:neethi:jar:2.0.4"


SUNACTIVATION = ["javax.activation:activation:jar:1.1.1"]
SUNMAIL = ["javax.mail:mail:jar:1.4.1", SUNACTIVATION]
SLF4J = group(%w{ slf4j-api slf4j-log4j12 jcl104-over-slf4j }, :under=>"org.slf4j", :version=>"1.4.3")

STAX_API = [ "stax:stax-api:jar:1.0.1" ]


WOODSTOX = [ "woodstox:wstx-asl:jar:3.2.4" ]
WS_COMMONS_SCHEMA = "org.apache.ws.commons.schema:XmlSchema:jar:1.3.1"
WSDL4J = [ "wsdl4j:wsdl4j:jar:1.6.1" ]

XERCES = [
  "xerces:xercesImpl:jar:2.9.1",
  "xerces:xmlParserAPIs:jar:2.9.0" ]
XMLBEANS = "org.apache.xmlbeans:xmlbeans:jar:2.4.0"
XMLUNIT = ["xmlunit:xmlunit:jar:1.1"]
AXIS2 = [
  group("axis2-kernel", "axis2-adb", "axis2-xmlbeans", "axis2-json", "axis2-transport-local","axis2-transport-http", :under=>"org.apache.axis2", :version=>"1.5.5"),
  BACKPORT,
  NEETHI,
  SUNMAIL
]
HTTP_CORE = "org.apache.httpcomponents:httpcore:jar:4.0"
TEMPO = [
  group("tempo-tms-common", :under=>"org.intalio.tempo", :version=>"6.3.0.001")
]

BPMS_COMMON = ["com.intalio.bpms.common:bpms-common:jar:1.0.0.0"]
