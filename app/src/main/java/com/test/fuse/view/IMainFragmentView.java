package com.test.fuse.view;

public interface IMainFragmentView {

    void showProgressBar();
    void hideProgressBar();
    void paintEditText(boolean isOK);
    void showAlert(int alert);
    void showImage(String url);
    void setEditText(String companyName);
}
