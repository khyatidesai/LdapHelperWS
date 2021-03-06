#
#  Copyright (C) 2009, Intalio Inc.
#
#  The program(s) herein may be used and/or copied only with the
#  written permission of Intalio Inc. or in accordance with the terms
#  and conditions stipulated in the agreement/contract under which the
#  program(s) have been supplied.

require File.join(File.dirname(__FILE__), "repositories.rb")
require File.join(File.dirname(__FILE__), "dependencies.rb")

# Keep this structure to allow the build system to update version numbers.
VERSION_NUMBER = "1.0.0.0-SNAPSHOT"
 

define "ldap-helper-ws" do  
  project.version = VERSION_NUMBER
  project.group = "org.intalio.ldaphelper"
  compile.options.source = "1.5"
  compile.options.target = "1.5"
  libs = AXIS2, APACHE_COMMONS[:httpclient], APACHE_COMMONS[:lang], APACHE_COMMONS[:codec],LOG4J, JUNIT,SLF4J, XMLBEANS, AXIOM, STAX_API, WSDL4J, WS_COMMONS_SCHEMA,UNBOUND_ID,HTTP_CORE
 
  compile.with libs
  package(:aar)

end

