<h1>Ulises Map Project</h1>

Is a big project commposed for Server and Client applications. The objective of project is to enjoy the users vacations providing a composed routes or turistic points of interest in diferent cities and countries.


<h2>UlisesMap Server</h2> 

Is a server application for manage a UlisesMap Project database, connect with Ulises MapClients and manage clients requirements. Is based on Tomcat server and a PostgresSQL database.  


<h3>UlisesMap Server on OpenShift</h3>

This git repository helps you get up and running quickly a server installation on OpenShift.
Running on OpenShift

Create an account at http://www.openshift.com/

Create a new aplication with tomcat server and postgres database

That's it, you can now checkout your application at:

http://MYAPLICATION-MYACCOUNTDOMAIN.rhcloud.com

Integrate with eclipse, download from eclipse market a JBoss Tools and install only JBoss Openshift Tools

enjoy your encoding! 

<h3>UlisesMap OpenShift cartridge</h3>

Openshift uses a cartridge same as a library for use cartridge you can add in pom.xml file.
UlisesMap Server use:
<ul>
        <li>javax.servlet-api</li>
  
	<li>postgresql</li>

	<li>json</li>
</ul>	
  

