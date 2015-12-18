package com.test.fuse.network;

import com.test.fuse.model.CompanyResponse;
import com.test.fuse.utils.Constants;

import retrofit.Callback;
import retrofit.RestAdapter;

public class RestClient {

    private RestServices restServices;

    public RestClient() {

        // Create RestAdapter for request
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.END_POINT)
                .build();

        restServices = restAdapter.create(RestServices.class);
    }

    // Validate company name
    public void validateCompany(String companyName, Callback<CompanyResponse> companyResponseCallback) {
        restServices.validateCompany(companyName, companyResponseCallback);
    }
}