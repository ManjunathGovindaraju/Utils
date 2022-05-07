# JAVA Utils - DoorDash API
Doordash developer portal (https://developer.doordash.com/en-US/docs/drive/how_to/JWTs/) doesn't have example on how to create JWTs using JAVA. So I thought of creating a simple utile for the same and sharing with those who are interseted. 

Prerequisite 
Add the following in pom.xml

    <dependency>  
     <groupId>com.auth0</groupId>  
     <artifactId>java-jwt</artifactId>  
     <version>3.19.1</version>  
    </dependency>

Register as developer at DoorDash developer portal and create the following credentials. 
 - Developer ID 
 - Key ID and  
 - Signing Secret

Usage 

    String jwt = DoordashUtils.generateJwt(developerId, keyId, signingSecret);
