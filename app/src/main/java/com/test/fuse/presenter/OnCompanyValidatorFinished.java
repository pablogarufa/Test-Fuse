package com.test.fuse.presenter;

import com.test.fuse.model.CompanyResponse;

public interface OnCompanyValidatorFinished {

    void onSuccess(CompanyResponse companyResponse);
    void onFailure();
}
