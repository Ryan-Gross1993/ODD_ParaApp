package com.opendatadelaware.paratransitapp.userregistration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.opendatadelaware.paratransitapp.R;
import com.opendatadelaware.paratransitapp.home.HomeActivity;
import com.opendatadelaware.paratransitapp.model.ApplicantAddress;
import com.opendatadelaware.paratransitapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class RegistrationActivity extends FragmentActivity implements BasicCredentialsFragment.BasicCredentialsListener, ApplicantAddressFragment.ApplicantAddressListener {

    User applicantUser;


    @Override
    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_registration);

        BasicCredentialsFragment basicCredentialsFragment = new BasicCredentialsFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, basicCredentialsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void createApplicantProfile(User user) {

        applicantUser = new User(user.getApplicantName(), user.getApplicantEmail(), user.getApplicantPassword(), user.getGender());
        applicantUser.setBirthday(user.getBirthday());


        ApplicantAddressFragment applicantAddressFragment = new ApplicantAddressFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, applicantAddressFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void addDetailInformationToProfile(String address, String zipCode, String phoneNumber, String state, String lastFour) {

        ApplicantAddress applicantAddress = new ApplicantAddress(address, state, zipCode);

        applicantUser.setApplicantAddress(applicantAddress);
        applicantUser.setLastFour(lastFour);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.detach(fragment);

        transaction.commit();

        Intent mainMenuIntent = new Intent(this, HomeActivity.class);

        mainMenuIntent.putExtra("user", applicantUser);

        startActivity(mainMenuIntent);

    }
}
