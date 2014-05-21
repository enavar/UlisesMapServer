UlisesMap Server 

Is a server application for manage a UlisesMap Project database, connect with Ulises MapClients and manage clients requirements. Is based on Tomcat server and a PostgresSQL database.  


UlisesMap Server on OpenShift

This git repository helps you get up and running quickly a server installation on OpenShift.
Running on OpenShift

Create an account at http://www.openshift.com/

Create a new aplication with tomcat server and postgres database

That's it, you can now checkout your application at:

http://MYAPLICATION-MYACCOUNTDOMAIN.rhcloud.com

Integrate with eclipse, download from eclipse market a JBoss Tools and install only JBoss Openshift Tools

enjoy your encoding! 

UlisesMap OpenShift cartridge

Openshift uses a cartridge same as a library for use cartridge you can add in pom.xml file.
UlisesMap Server use:
<dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.0.1</version>
        <scope>provided</scope>
</dependency>
<dependency>
	<groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<version>9.2-1003-jdbc4</version>
</dependency>
<dependency>
	<groupId>org.json</groupId>
	<artifactId>json</artifactId>
	<version>20090211</version>
</dependency>     

