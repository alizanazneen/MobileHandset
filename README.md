Steps to run –  (Spring boot Rest full service+ Maven)

Pre Requisit :
- JDK 1.8
- Maven 3+
- Spring boot 2+

Steps 
------------
1)Clone the source code from the below repository - 
 
https://github.com/vaseemahmed01/Starzplay.git

2) Build the project –
   mvn clean install
3)Run the Spring boot command – 
   spring-boot:run
3)Test the Project
   mvn clean test
4) Urls to access the service – 
  http://localhost:8080/mobile/search?announceDate=1999&price=200
  http://localhost:8080/mobile/search?sim=eSim
  http://localhost:8080/mobile/search?priceEur=200
