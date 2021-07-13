# Credit_Card

This is a Java Application for Credit Card Processing. It reads records from any time of file such as CSV, XML and JSON. Further it checks the validates the card number. Based on the appropriate Credit Card type, it creates an object of Credit Card type class such as Master Card, Visa, American Express and Discover. New type of files and CreditCards can also be added in this application. This application creates an output file containing Card Number, Card Type and Error.

For this application, I have used Strategy, Chain of Responsibility and Factory pattern.

To run this code, please follow below steps:

A. To execute from Eclipse IDE, follow below steps:

--> Upload input file in creditcard folder.
--> Click on Run Configuration to run Client.java file.
--> Enter arguments for eg. sample.csv test.csv
--> Click Apply
--> Click OK.

B. To execute using JAR file, please follow below steps:

--> Download the JAR file.
--> Save the input file in the same path as of JAR file.
--> Navigate to the JAR file path from command prompt.
--> Execute below command: java -jar creditcard-0.0.1-SNAPSHOT-jar-with-dependencies.jar sample.csv test.csv
