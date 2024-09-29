package com.genericApiFramework.frameworkUtils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class GetRequests extends BaseRequest{
        @Override
        public RequestSpecification buildRequest() {
            return RestAssured.given()
                    .baseUri(baseUrl)
                    .headers(headers)
                    .queryParams(requestParams);
        }
    }
