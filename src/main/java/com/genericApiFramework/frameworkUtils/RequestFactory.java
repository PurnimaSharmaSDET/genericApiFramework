//package com.genericApiFramework.frameworkUtils;
//
//import io.restassured.response.Response;
//
//import java.util.Map;
//
//public class RequestFactory {
//    public static BaseRequest createRequest(String type, String baseUrl, String serviceUrl,
//                                            Map<String, String> headers, String requestBody,
//                                            Map<String, String> requestParams) {
//        BaseRequest request = null;
//        switch (type.toUpperCase()) {
//            case "GET":
//                request = new GetRequests();
//                break;
//            case "POST":
//                // Similar for PostRequest, PutRequest, etc.
//        }
//        if (request != null) {
//            request.setBaseUrl(baseUrl);
//            request.setServiceUrl(serviceUrl);
//            request.setHeaders(headers);
//            request.setRequestBody(requestBody);
//            request.setRequestParams(requestParams);
//        }
//        return request;
//    }
//}
//// Using the framework in a test
//BaseRequest request = RequestFactory.createRequest("GET", "https://api.example.com", "/users", headers, null, params);
//Response response = request.buildRequest().get(request.getServiceUrl());
//}
//
//public void main() {
//}
