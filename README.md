Submission Notes:
=================
This project for submission is built using Spring Boot on Java 8.

Instructions for usage/testing: 
===============================
1)Ensure appropriate db details(MySQL) is updated in application.properties 
2)Execute 'mvn package' 
3)Execute 'java -jar target/vatapp-0.0.1-SNAPSHOT.jar'

Note: Ensure 8080 port is free on machine where app is getting deployed. 
Also,the app auto-creates the db table on mysql and drops them , when brought down .

App URL :  http://localhost:8080/default.html

The app is now addressing all the following mandatory tasks 

1.Saves expenses as entered to a database.
2.Retrieves them for display on the page. 
3.Add a new column to the table displaying the VAT amount for each expense.
4.Alter the README to contain instructions on how to build and run your app.

and also the extra credit task
1.Calculate the VAT client-side as the user enters a new expense, before they save the expense to the database.


Note to evaluator:
==================
Being the contest, more focus has been given to address the functional requirements from backend perspective
and ensured fair coverage on the other aspects of structure , test ,etc.

Also for UI , the shared client code is reused but placed @ src/webapp directory now.
The UI code changed for submission are expenses-content.html and expenses-controller.js under webapp/src/js.
Due to gulpfile build issues on local, packed the above changes directly in codingtest.min.js @ webapp/static/js.

Kindly reach out via email , for more info or any issues in app usage.