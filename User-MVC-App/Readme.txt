Creating User Registration form using SpringMVC
Tools Required:
1)Eclipse IDE for Enterprise Java & Web Developers
2)MySql Work Bench
3)Apache TomCat server v9.0

Steps:
1)Create A Maven project
	File -> new -> Maven Project -> Next -> Provide Filter org.apache.maven.archetypes
	Where,
	artifact ID must be maven-archetype-webapp
	Version 1.4
	Click Finish
	then Provide Y in console at 33% of the project creation
2)Provide the following maven dependencies (pom.xml)
	i)Spring context (5.3.18)
	ii)Spring web MVC (5.3.18)
	iii)Servlet-api
	iv)Hibernate-Core relocation (5.6.15 final)
	v)MySQL Connector java(8.0.28)
3)Complete Servlet-Mapping for DispatcherServlet in web.xml & change the welcome-file
4)Provide configuration file i.e., servletName-servlet.xml in WEB-INF folder
5)create classes folder in it create META-INF & provide persistence.xml file
6)Provide a folder Views where all the necessary web pages are given
7)finally select project & run on server
	