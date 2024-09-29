package com.genericApiFramework;

import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.genericApiFramework.dtoObjects.dogs.DogApiResponse;
import com.genericApiFramework.dtoObjects.dogs.DogsArrayResponse;
import com.genericApiFramework.frameworkUtils.BaseRequest;
import com.genericApiFramework.frameworkUtils.RequestFactoryClass;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class SampleTest {

    @Test
    public void sample(){
        HashMap<String,String> headerMap=new HashMap<>();
        headerMap.put("accept","application/json");

        HashMap<String,String> param=new HashMap<>();
        param.put("status","available");
        BaseRequest request = RequestFactoryClass.createRequest("GET",
                "https://petstore3.swagger.io", "/api/v3/pet/findByStatus",
                headerMap,
                null, param);
        Response response = request.buildRequest().get(request.getServiceUrl());
        System.out.println(response.getBody().prettyPrint());


    }
}
