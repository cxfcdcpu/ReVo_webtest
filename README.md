# ReVo_webtest

This is the backend of the central authority. The frontend is in another project:
https://github.com/cxfcdcpu/secure_data_sharing_dashboard

## setup environment
The backend is developed in Ubuntu but could also be able to run in Windows.

### Ubuntu environment setup:
 ### 1. install database: 
 We use MySQL database. To use MySQL, install LAMP service using the following instruction:
    https://ubuntu.com/server/docs/lamp-applications
    
 ### 2. Setup database:
 Use phpMyAdmin to setup the database and the table as following:
 
 Login phpMyAdmin:
  ![login phpMyAdmin](https://github.com/cxfcdcpu/ReVo_webtest/blob/main/phpMyAdmin.png)
 
 Find import on top:
 ![import](https://github.com/cxfcdcpu/ReVo_webtest/blob/main/phpMyAdmin_2.png)
 
 Import database from test_login.sql:
 ![import](https://github.com/cxfcdcpu/ReVo_webtest/blob/main/phpMyAdmin_3.png)
 
 Check you got all three tables:
 ![import](https://github.com/cxfcdcpu/ReVo_webtest/blob/main/phpMyAdmin_4.png)
 
    
 ### 3. install eclipse:
 As our application is still under development, use eclipse to develop and run our applications. Follow the following instruction to install eclipse in Unbuntu:
    https://linuxize.com/post/how-to-install-the-latest-eclipse-ide-on-ubuntu-18-04/
    
 ### 4. install Tomcat server for eclipse:
 Our backend server is run with Tomcat. Installing tomcat server in eclipse is super easy, following the instruction below:
    https://crunchify.com/step-by-step-guide-to-setup-and-install-apache-tomcat-server-in-eclipse-development-environment-ide/
    
 ### 5. Buildpath:
 All the required library are in the path: 
    ReVo_webtest/src/main/webapp/WEB-INF/lib/
 Using the following to build your build path in eclipse IDE:
 ![setup buildpath](https://github.com/cxfcdcpu/ReVo_webtest/blob/main/buildPath.png)
 
 
### Windows and MacOS environment setup:
The only difference of windows and Mac system is the SQL database installation and LAMP server setup. In Windows and MacOS, we use MAMP. To install MAMP follow the following links:
https://www.mamp.info/en/downloads/

Instructions:
#### Windows:
https://documentation.mamp.info/en/MAMP-Windows/Installation/

#### MacOS:
https://documentation.mamp.info/en/MAMP-Mac/Installation/


 
## Use the API:
The API has two parts, the RestFul API that manage mission, User, and Match which resides in manageAPI package and the attribute based encryption API which resides in revoabe package. The structure of the project are as follows:
![structure](https://github.com/cxfcdcpu/ReVo_webtest/blob/main/structure.png)

### To use the manageAPI:
All API are java servlet. To use the API, in eclipse, select server and run. Note your IP. To call the API check the report file. 
https://github.com/cxfcdcpu/ReVo_webtest/blob/main/August_Report%20.docx

### To use the revo-ABE:
revo-ABE is a powerful attribute based ecryption algorithm which is originally written in python using charm library. In this API, it is rewritten using java with JPBC and antlr library. The implementation is in the revoabe package. To use the library, user need to create a revo-abe instance first. Then generate private key and public key for a user in the bootstrap stage. Then we can use the encryp and decrypt function to encrypt any byte array to ciphertext and decrypt any ciphertext to byte array. Both encrypt and decrypt function has static and non-static implementation as following. 
![encryption](https://github.com/cxfcdcpu/ReVo_webtest/blob/main/encrypt.png)

![decryption](https://github.com/cxfcdcpu/ReVo_webtest/blob/main/decrypt.png)
(Note: pairing can be generated using JPBC pairing. The buildpath setup are shown in previous of this document)

Also, the ciphertext can be generated from byte array and convert to byte array with the class function as follows:
![totext](https://github.com/cxfcdcpu/ReVo_webtest/blob/main/toCipherText.png)

![toarray](https://github.com/cxfcdcpu/ReVo_webtest/blob/main/toByteArray.png)

To test the Revo-abe, just use the test code in:
https://github.com/cxfcdcpu/ReVo_webtest/blob/main/src/main/java/test_revo_abe/TestReVoABE_encrypt.java

![test](https://github.com/cxfcdcpu/ReVo_webtest/blob/main/testEncrypt.png)




 
 
