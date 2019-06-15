# netplus
Test fot Solinftec

How to execute:
 1. Clone the repository
 2. Open repository with any console
 3. Run mvn clean package
 4. Run java -jar .\target\netplus-0.0.1-SNAPSHOT.jar
 
 Obs.: It will run on port 8080 by deafault.

Ready to use with Postman or any other API consumer:

 1. Use HTTP POST request.
 2. URL: http://localhost:8080/api/v1/assistant/
 3. Body: { "message": "{type your message here}" }

 Example:
 ![Capturar](https://user-images.githubusercontent.com/37852476/59555396-bca81600-8f87-11e9-8a6c-b3fa214911b1.PNG)
