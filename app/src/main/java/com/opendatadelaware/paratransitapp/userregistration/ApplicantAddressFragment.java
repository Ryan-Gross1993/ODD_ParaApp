package com.opendatadelaware.paratransitapp.userregistration;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.opendatadelaware.paratransitapp.R;
import com.opendatadelaware.paratransitapp.model.State;

public class ApplicantAddressFragment extends Fragment {

    View applicantAddressView;
    ApplicantAddressListener applicantAddressListener;
    EditText streetAddress;
    EditText zipCode;
    EditText phoneNumber;
    EditText lastFourSSN;
    Spinner stateSpinner;
    ImageButton nextButton;
    String[] stateArray;

    public interface ApplicantAddressListener {

        void addDetailInformationToProfile(String address, String zipCode, String phoneNumber, String state, String lastFour);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        applicantAddressView = inflater.inflate(R.layout.applicant_address_layout, container, false);

        streetAddress = applicantAddressView.findViewById(R.id.addressEditText);
        zipCode = applicantAddressView.findViewById(R.id.zipCodeEditText);
        phoneNumber = applicantAddressView.findViewById(R.id.phoneNumberEditText);
        lastFourSSN = applicantAddressView.findViewById(R.id.lastFourSSN);
        stateSpinner = applicantAddressView.findViewById(R.id.stateSpinner);
        nextButton = applicantAddressView.findViewById(R.id.applicantAddressNextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String address = streetAddress.getText().toString();
                String zipCodeAsString = zipCode.getText().toString();
                String phoneNumberAsString = phoneNumber.getText().toString();
                String lastFourAsString = lastFourSSN.getText().toString();
                String state = stateSpinner.getSelectedItem().toString();
                applicantAddressListener.addDetailInformationToProfile(address, zipCodeAsString, phoneNumberAsString, state, lastFourAsString);

            }

        });

        stateArray = State.toStringArray();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this.getActivity(), R.layout.spinner_layout, stateArray);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        stateSpinner.setAdapter(arrayAdapter);

        stateSpinner.setSelection(7);

        return applicantAddressView;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            applicantAddressListener = (ApplicantAddressListener) context;
        } catch (Exception e) {
            Log.e("Error: ", e.getCause().toString());
        }

    }
}
