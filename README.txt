############################ AQL sms soap api ############################

Overview
--------
The is a thin java wrapper client api for the aql.com soap messaging api. It makes use of the Spring-ws and Castor packages to send and receive sms messages to and from the aql.com soap messaging web service.


Build
-----
To build this project use Maven (http://apache.maven.org). Checkout the project to your local machine and from the command line run 

mvn clean install

This will build and install the jaql_message.jar package into your local maven repository.


Usage
-----
Use this package in your own Java applications as a simple way of accessing the aql.com sms soap api. The simplest way to implement it is with Spring (version 3)

In your own project maven build file add a dependecy to the jaql_message.jar like so -

<dependency>
    <groupId>com.aql.message</groupId>
    <artifactId>jaql_message</artifactId>
    <version>1.0</version>
</dependency>

Set up the aql inbound servlet by declaring it in your web.xml. This servlet will receive inbound messages and status update data from aql

<servlet>
        <servlet-name>AqlInboundServlet</servlet-name>
        <servlet-class>com.aql.message.mo.AqlInboundServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
</servlet>

<servlet-mapping>
        <servlet-name>AqlInboundServlet</servlet-name>
        <url-pattern>/aql.jsp</url-pattern>
</servlet-mapping>

Now import the jaql_message.xml application context into your own project's Spring application context file like so -

<import resource="classpath:jaql_message.xml"/>

No create a client bean which will contain your aql.com api credentials, i.e. your own aql.com username and password. You also need to specify a call back url so aql.com can push sms status update data to your web application. Create the bean like so -

<bean id="aqlSOAPClient" class="com.aql.message.mt.AqlMTSoapClient">
            <constructor-arg ref="aqlWebServiceTemplate"/>
	    <!-- aql callback url -->
            <constructor-arg>
                <value><![CDATA[http://<your-web-app-url>/aql.jsp?reportcode=%code&destinationnumber=%dest]]></value>
            </constructor-arg>
	    <!-- aql username -->
            <constructor-arg>
                <value>your-aql-username</value>
            </constructor-arg>
	    <!-- aql password -->
            <constructor-arg>
                <value>your-aql-password</value>
            </constructor-arg>
</bean>

Now in your own code you can access the bean and send messages by creating an MTSmsMessage object and passing it into the sendMTMessage() method, like so -


MTSmsMessage mtMessage = new MTSmsMessage();
mtMessage.setDestinationArray(new String[] {"+447538178963"});
mtMessage.setMessage(message.getContent());
        
try {
    aqlSOAPClient.sendMTMessage(mtMessage);

} catch (AqlException e) {
    e.printStackTrace();
}


Contact jphunsley@gmail.com for further help :-)


