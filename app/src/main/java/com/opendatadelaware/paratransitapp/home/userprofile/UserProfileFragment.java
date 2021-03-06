package com.opendatadelaware.paratransitapp.home.userprofile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.opendatadelaware.paratransitapp.R;
import com.opendatadelaware.paratransitapp.model.User;


public class UserProfileFragment extends Fragment {

    View userProfileView;
    TextView fullName;
    TextView birthday;
    TextView address;
    TextView phone;
    TextView email;
    User applicantUser;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        userProfileView = inflater.inflate(R.layout.fragment_user_profile, container, false);

        fullName = userProfileView.findViewById(R.id.userName);
        address = userProfileView.findViewById(R.id.userAddress);
        phone = userProfileView.findViewById(R.id.userPhone);
        email = userProfileView.findViewById(R.id.userEmail);
        birthday = userProfileView.findViewById(R.id.userDOB);

        if (getActivity().getIntent().hasExtra("user")) {

            applicantUser = (User) getActivity().getIntent().getSerializableExtra("user");

            fullName.setText(applicantUser.getApplicantName());
            Log.i("Applicant Name", applicantUser.getApplicantName());
            birthday.setText(applicantUser.getBirthday());
            address.setText(applicantUser.getApplicantAddress().toString());
            phone.setText(applicantUser.getPhoneNumber());
            email.setText(applicantUser.getApplicantEmail());

        } else {

            fullName.setText("John Doe ");
            birthday.setText("01/01/1980");
            address.setText("123 Rainbow Road, Wilmington, DE 19803");
            phone.setText("302-123-4567");
            email.setText("john.doe@gmail.com");
        }



        return userProfileView;
    }

}