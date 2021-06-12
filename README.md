****************************************************
	RBAC Application - Role Based Access Control
****************************************************

* Structure:
	1. src/main/scala/models - this folder contains all the application related models and entities
	2. src/main/scala/dao - this folder contains all the DAOs required for the data in/out flow
	3. src/main/scala/services - this folder contains all the services responsible for model to DAO binding
	4. src/main/scala/driver - this folder contains two files
									a. Init.scala -> To initialize the application with dummy data(can be altered to run different use cases)
									b. Driver.scala -> This class after calling Init, runs a series of Entitlement checks to test the validity of the application

* Tech Specs:
	* Language used - Scala
	* * Build Tool used - sbt (Kindly refer to https://www.scala-sbt.org/1.x/docs/Setup.html to get the steps)

* Steps to run the application:
	1. cd to the folder where the project is stored (/../../rbac).
	2. 2. Run sbt. This will open up the sbt console.
	3. 3. Type ~run. 			

*Assumptions
	1. There is only one type of resource
	2. All the user are part of the application and access can be provided to all the resources across the system
