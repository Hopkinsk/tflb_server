About
-----
* Grails application using Grails 2.3.9 (See application.properties)


Setup
-----
* Install Java 7 (Java 1.7 JDK) and ensure “$ java -version” in terminal shows “1.7.*” as default
* Install and set default grails version to 2.3.9 via [sdkman](http://sdkman.io/install.html)
* Install and run [SQLite](https://www.sqlite.org/)
* In the project directory run:
	* ```grails clean``` //Cleans project
	* ```grails refresh-dependencies``` //Loads dependencies 
	* ```./create_tflb_links.sh``` 		//Connects tflb_portal. Portal must be built with grunt with production urls turned on.
	* ```grails -reloading run-app```	//Runs server locally on port 8080



Integrating the frontend
------------------------
Run create_tflb_links.sh

- web-app/css -> <path-to-html-project>/pathologistportal/static/css web-app/css
 - ln -s ../../pathologistportal/dist/release_bundle/static/css
- web-app/images -> <path-to-html-project>/pathologistportal/dist/release_bundle/static/images
 - ln -s ../../pathologistportal/dist/release_bundle/static/images
- web-app/js -> <path-to-html-project>/pathologistportal/dist/release_bundle/static/js
 - ln -s ../../pathologistportal/dist/release_bundle/static/js
- grails-app/views/index.gsp -> <path-to-html-project>/pathologistportal/dist/release_bundle/index.gsp
 


