package com.test.fuse.presenter;

import com.test.fuse.model.CompanyResponse;
import com.test.fuse.model.CompanyValidatorInteractor;
import com.test.fuse.R;
import com.test.fuse.view.IMainFragmentView;

public class MainPresenter implements OnCompanyValidatorFinished {

    private IMainFragmentView view;
    private CompanyValidatorInteractor interactor;

    public MainPresenter(IMainFragmentView view) {

        this.view = view;
        this.interactor =  new CompanyValidatorInteractor(this);
    }

    public void validateCompany(String company){

        // Validate company name
        if (company.length() > 1) {

            view.showProgressBar();

            // Remove white spaces from company name
            String noSpacesCompany = company.replaceAll("\\s+","");

            // request validation for that company anme
            interactor.validateCompany(noSpacesCompany);
        } else {

            // Show snackbar alert
            view.showAlert(R.string.error_edittext_length);
        }
    }

    @Override
    public void onSuccess(CompanyResponse companyResponse) {

        view.hideProgressBar();

        // Set edit text with company name
        view.setEditText(companyResponse.getName());

        // paint editText in green
        view.paintEditText(true);

        // download and show image from url
        view.showImage(companyResponse.getLogo());
    }

    @Override
    public void onFailure() {

        view.hideProgressBar();

        // paint editText in red
        view.paintEditText(false);
    }
}
