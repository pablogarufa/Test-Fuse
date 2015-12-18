package com.test.fuse.network;

import com.test.fuse.model.CompanyResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface RestServices {


    // Interface with dynamic path for validate company name
    @GET("/{companyName}.fusion-universal.com/api/v1/company.json")
    void validateCompany(@Path("companyName") String companyName, Callback<CompanyResponse> callback);
}
