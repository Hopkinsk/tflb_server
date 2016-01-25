About
-----
* Grails application using Grails 2.3.9 (See application.properties)


Setup
-----
* Install Java 7 (Java 1.7 JDK) and ensure “$ java -version” in terminal shows “1.7.*” as default
* Install and set default grails version to 2.3.9 via [sdkman](http://sdkman.io/install.html)
* Install and run [SQLite](https://www.sqlite.org/)
	* Create SQL table'tflb'
	* (Set DB configs in /grails-app/conf/DataSource.groovy) 
* In the project directory run:
	* ```grails clean``` //Cleans project
	* ```grails refresh-dependencies``` // Loads dependencies 
	* ```./create_tflb_links.sh``` 		// Connects tflb_portal. Portal must be built with grunt with production urls turned on.
	* ```grails -reloading run-app```	// Runs server locally on port 8080


Integrating the frontend
------------------------
* Follow instructions to build tflb-portal front-end 
* Run create_tflb_links.sh to create symbolic links to tflb-portal 


Authentication
---------------
Currently, there is no authentication on the project. LDAP can be configured: https://grails.org/plugin/ldap
A general password 'asap' is set to view the application. This password is set statically in /tflb-portal/app/apps/study/views.js


