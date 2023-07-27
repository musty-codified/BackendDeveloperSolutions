package com.activedgetechnologies.BackendDeveloperSolutions.exercise3;


import org.springframework.stereotype.Component;

@Component
public class ResponseProvider <T>{
    public ApiResponse success(T data){
        return new ApiResponse<T>("Request Successful", true,  data);
    }
    public ApiResponse error(String errorMessage){
        return new ApiResponse<T>(errorMessage, true, null);
    }
}
