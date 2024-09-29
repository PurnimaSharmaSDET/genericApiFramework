# genericApiFramework


Here is how you can explain API automation framework during
your interviews
Blog Link : https://medium.com/@sharma0purnima/how-to-explain-rest-assured-framework-in-interview-dc0b8ad0e4f3


1. Overview of the Framework
   Start with a high-level overview:

Introduction: “I have developed a REST Assured-based framework to streamline API testing. The framework is built using the Factory Design Pattern, which allows for the dynamic creation of request objects.”
Purpose: “The main goal is to make the API testing process modular, maintainable, and easily extensible.”
2. Design Patterns and Principles
   Discuss the design patterns and principles used:

Factory Design Pattern: “The Factory Design Pattern is used to create different types of request objects (GET, POST, PUT, DELETE) based on the input parameters. This abstracts the instantiation logic and provides a single point of entry for object creation.”
Abstract Class: “An abstract class is employed to define the common structure for all request objects. This includes attributes like base URL, service URL, headers, request body, request parameters, and HTTP methods. By using an abstract class, we ensure that every request object has a consistent structure.”
3. Detailed Implementation
   Delve into the details of how it works:

Abstract Class: “The abstract class, let’s call it BaseRequest, contains fields for base URL, service URL, headers, request body, request parameters, and the HTTP method. It also defines abstract methods like buildRequest() which must be implemented by subclasses."
Concrete Classes: “Subclasses like GetRequest, PostRequest, PutRequest, etc., extend BaseRequest and implement the buildRequest() method to construct the specific type of request."
Factory Class: “A RequestFactory class contains a method createRequest(String type, ...) which takes the request type (GET, POST, etc.) and other parameters, then returns an instance of the corresponding request object. This decouples the client code from the instantiation logic."
4. Usage in the Framework
   Explain how these elements come together in the framework:

Request Creation: “At the framework level, when a test needs to create a request, it calls RequestFactory.createRequest(), passing the necessary parameters. The factory returns a fully constructed request object."
REST Assured Integration: “The constructed request object is then passed to REST Assured methods. For example, RestAssured.given().headers(request.getHeaders()).body(request.getBody()).when().post(request.getServiceUrl()) for a POST request."
5. Benefits
   Highlight the benefits of this approach:

Modularity: “Each request type is encapsulated in its own class, making the code more modular and easier to maintain.”
Reusability: “Common logic is abstracted in the BaseRequest class, promoting reusability and reducing code duplication."
Extensibility: “New request types can be easily added by creating new subclasses of BaseRequest and updating the factory logic."
Test Readability: “Test cases are more readable as the request creation logic is abstracted away, allowing testers to focus on test scenarios rather than request construction.”
6. Example Code
   Provide a brief code snippet to illustrate your explanation:
```java
/ Abstract BaseRequest class
public abstract class BaseRequest {
protected String baseUrl;
protected String serviceUrl;
protected Map<String, String> headers;
protected String requestBody;
protected Map<String, String> requestParams;
protected String method;
public abstract RequestSpecification buildRequest();
// Getters and setters for fields
}
// Concrete GetRequest class
public class GetRequest extends BaseRequest {
@Override
public RequestSpecification buildRequest() {
return RestAssured.given()
.baseUri(baseUrl)
.headers(headers)
.queryParams(requestParams);
}
}
// RequestFactory class
public class RequestFactory {
public static BaseRequest createRequest(String type, String baseUrl, String serviceUrl,
Map<String, String> headers, String requestBody,
Map<String, String> requestParams) {
BaseRequest request = null;
switch (type.toUpperCase()) {
case "GET":
request = new GetRequest();
break;
case "POST":
// Similar for PostRequest, PutRequest, etc.
}
if (request != null) {
request.setBaseUrl(baseUrl);
request.setServiceUrl(serviceUrl);
request.setHeaders(headers);
request.setRequestBody(requestBody);
request.setRequestParams(requestParams);
}
return request;
}
}
// Using the framework in a test
BaseRequest request = RequestFactory.createRequest("GET", "https://api.example.com", "/users", headers, null, params);
Response response = request.buildRequest().get(request.getServiceUrl());
```
7. Conclusion
   Conclude by summarising the key points:

Summary: “In summary, the use of the Factory Design Pattern and an abstract class structure in my REST Assured framework promotes modularity, reusability, and extensibility. This approach significantly enhances the maintainability and scalability of our API testing suite.”