package com.test.fuse.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;
import com.test.fuse.view.IMainFragmentView;
import com.test.fuse.presenter.MainPresenter;
import com.test.fuse.R;

public class MainFragment extends Fragment implements IMainFragmentView, View.OnClickListener {

    private MainPresenter presenter;
    private LinearLayout mainLayout;
    private Button buttonSubmit;
    private Button buttonClear;
    private EditText etCompany;
    private ProgressBar progressBar;
    private ImageView imageLogo;
    private TextInputLayout inputLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mainLayout = (LinearLayout) rootView.findViewById(R.id.fragment_main_main_layout);
        buttonSubmit = (Button) rootView.findViewById(R.id.fragment_main_btn_submit);
        buttonClear = (Button) rootView.findViewById(R.id.fragment_main_btn_clear);
        etCompany = (EditText) rootView.findViewById(R.id.fragment_main_et_company);
        progressBar = (ProgressBar) rootView.findViewById(R.id.fragment_main_progressbar);
        imageLogo = (ImageView) rootView.findViewById(R.id.fragment_main_image_logo);
        inputLayout = (TextInputLayout) rootView.findViewById(R.id.fragment_main_input_layout);

        // Create presenter to manage bussiness logic
        presenter = new MainPresenter(this);

        buttonSubmit.setOnClickListener(this);
        buttonClear.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void showProgressBar() {

        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {

        progressBar.setVisibility(View.GONE);
    }

    // Set EditText background
    @Override
    public void paintEditText(boolean isOK) {

        // If result is OK paint in green else in red
        if (isOK) {

            inputLayout.setBackgroundColor(Color.GREEN);
        } else {

            inputLayout.setBackgroundColor(Color.RED);
        }
    }

    // Use snackBar alert
    @Override
    public void showAlert(int alert) {

        String message = getActivity().getResources().getString(alert);
        Snackbar snackbar = Snackbar.make(mainLayout, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    public void showImage(String url) {

        // Load image url into logo imageview
        Picasso.with(getActivity()).load(url).into(imageLogo);
    }

    // Edit text with company name
    @Override
    public void setEditText(String companyName) {

        etCompany.setText(companyName);
    }

    // Clear logo imageView and EditText background
    private void reset(){

        inputLayout.setBackgroundColor(Color.WHITE);
        imageLogo.setImageResource(android.R.color.transparent);
    }

    // Manage click events
    @Override
    public void onClick(View v) {

        int option = v.getId();

        switch (option) {

            // Tap on submit button
            case R.id.fragment_main_btn_submit:

                hideKeyboard();
                reset();
                presenter.validateCompany(etCompany.getText().toString());
                break;

            // Tap on clear button
            case R.id.fragment_main_btn_clear:
                hideKeyboard();
                reset();
                break;

            default:
                break;
        }
    }

    // Hide sofware keyboard
    public void hideKeyboard() {

        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
