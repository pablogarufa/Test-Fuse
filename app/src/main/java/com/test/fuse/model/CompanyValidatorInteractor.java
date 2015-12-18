package com.test.fuse.model;

import com.test.fuse.App;
import com.test.fuse.presenter.OnCompanyValidatorFinished;
import com.test.fuse.network.RestClient;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class CompanyValidatorInteractor implements Callback<CompanyResponse> {

    private OnCompanyValidatorFinished listener;
    private RestClient restClient;

    public CompanyValidatorInteractor(OnCompanyValidatorFinished listener) {

        this.listener = listener;
        restClient = App.restClient;
    }

    public void validateCompany(String companyName) {

        // Call web service
        restClient.validateCompany(companyName, this);
    }

    @Override
    public void success(CompanyResponse companyResponse, Response response) {

        listener.onSuccess(companyResponse);
    }

    @Override
    public void failure(RetrofitError error) {

        listener.onFailure();
    }
}
