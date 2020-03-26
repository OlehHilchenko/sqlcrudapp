This application is used to store Developer objects.
In it you can perform four basic operations:
        1). Add new Developer.
        2). Get view Developer.
        3). Remove Developer.
        4). Update Developer.
Important! For local launch, several settings need to be made.
You will need: mySQL local server.
Maven. Java sdk.

First: Need to create a schema "csuser_db" in mySQL.
       You must create a user "root" with pass "root" to work with the database.
       
Secondly: Download the maven dependencies to the local repository:
          mvn dependency:get
          We will assemble the project:
          mvn clean install
          
Thirdly: Launch the application: src/main/java/com/olehhilchenko/Main