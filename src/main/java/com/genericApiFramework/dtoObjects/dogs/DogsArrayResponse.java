package com.genericApiFramework.dtoObjects.dogs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;

@Data
@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
public class DogsArrayResponse {
    List<DogApiResponse> dogResponse;
}
