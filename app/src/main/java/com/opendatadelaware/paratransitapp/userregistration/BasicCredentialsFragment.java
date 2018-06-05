package com.opendatadelaware.paratransitapp.userregistration;

import android.app.DatePickerDialog;
import android.content.Context;
import android.icu.text.SimpleDateFormat;
import java.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.opendatadelaware.paratransitapp.R;
import com.opendatadelaware.paratransitapp.model.User;
import com.opendatadelaware.paratransitapp.model.Gender;

import java.util.Locale;

public class BasicCredentialsFragment extends Fragment {

    View basicCredentialsView;
    EditText fullName;
    EditText emailAddress;
    EditText password;
    EditText verifiedPassword;
    EditText userBirthday;
    CheckedTextView maleCheckbox;
    CheckedTextView femaleCheckbox;
    ImageButton nextButton;
    Calendar birthdayCalendar;

    BasicCredentialsListener listener;

    public interface BasicCredentialsListener {
        void createApplicantProfile(User user);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        basicCredentialsView = inflater.inflate(R.layout.basic_credentials_layout_fragment, container, false);
        fullName = basicCredentialsView.findViewById(R.id.fullName);
        emailAddress = basicCredentialsView.findViewById(R.id.emailEditText);
        password = basicCredentialsView.findViewById(R.id.passwordEditText);
        verifiedPassword = basicCredentialsView.findViewById(R.id.verifyPasswordEditText);
        nextButton = basicCredentialsView.findViewById(R.id.basicCredentialsNextButton);
        maleCheckbox = basicCredentialsView.findViewById(R.id.maleCheckbox);
        femaleCheckbox = basicCredentialsView.findViewById(R.id.femaleCheckbox);
        userBirthday = basicCredentialsView.findViewById(R.id.userBirthday);

        birthdayCalendar = Calendar.getInstance();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String passwordInput = password.getText().toString();
                String verifiedPasswordInput = verifiedPassword.getText().toString();

                if (!isGenderChecked()) {
                    Toast toast = Toast.makeText(view.getContext(), "Passwords do not match.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                validatePasswordInputs(view, passwordInput, verifiedPasswordInput);

            }
        });

        final DatePickerDialog.OnDateSetListener birthdayDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.i("ON SET YEAR PRIOR", String.valueOf(birthdayCalendar.get(Calendar.YEAR)));
                Log.i("ON SET MONTH PRIOR", String.valueOf(birthdayCalendar.get(Calendar.MONTH)));
                birthdayCalendar.set(Calendar.YEAR, year);
                birthdayCalendar.set(Calendar.MONTH, month);
                birthdayCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                Log.i("ON SET YEAR AFTER", String.valueOf(birthdayCalendar.get(Calendar.YEAR)));
                Log.i("ON SET MONTH PRIOR", String.valueOf(birthdayCalendar.get(Calendar.MONTH)));




                Log.i("Calendar Day", birthdayCalendar.getTime().toString());
                updateUserBirthday(birthdayCalendar, userBirthday);

            }
        };

        userBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("ON CLICK YEAR", String.valueOf(birthdayCalendar.get(Calendar.YEAR)));
                Log.i("ON CLICK MONTH", String.valueOf(birthdayCalendar.get(Calendar.MONTH)));

                new DatePickerDialog(getActivity(), birthdayDateSetListener, birthdayCalendar.get(Calendar.YEAR), birthdayCalendar.get(Calendar.MONTH),
                        birthdayCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        setCheckbox(maleCheckbox);

        setCheckbox(femaleCheckbox);

        return basicCredentialsView;
    }

    public void setCheckbox(final CheckedTextView checkbox) {

        checkbox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (checkbox.isChecked()) {

                    checkbox.setChecked(false);

                } else {
                    checkbox.setChecked(true);
                }

            }

        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("ATTACH", "BasicCred is attached");

        try {
            listener = (BasicCredentialsListener) context;
        } catch (Exception e) {
            Log.e("Error: ", e.getCause().toString());
            e.printStackTrace();
        }

    }

    public void clearPasswords(View view) {

        int toastDuration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(view.getContext(), "Passwords do not match.", toastDuration);
        password.setText("");
        verifiedPassword.setText("");
        toast.show();
    }

    public boolean isGenderChecked() {

        return (!femaleCheckbox.isChecked() || !maleCheckbox.isChecked());

    }

    public Gender getApplicantGender() {

        return maleCheckbox.isChecked() ? Gender.MALE : Gender.FEMALE;

    }

    public void validatePasswordInputs(View view, String passwordOne, String passwordTwo) {

        boolean doPasswordsMatch = passwordOne.equals(passwordTwo);

        if (doPasswordsMatch) {

            String applicantEmail = emailAddress.getText().toString();
            String applicantName = fullName.getText().toString();
            Gender applicantGender = getApplicantGender();
            String birthday = userBirthday.getText().toString();

            User newUser = new User();
            newUser.setApplicantEmail(applicantEmail);
            newUser.setApplicantPassword(passwordOne);
            newUser.setApplicantName(applicantName);
            newUser.setGender(applicantGender);
            newUser.setBirthday(birthday);

            listener.createApplicantProfile(newUser);

        } else {
            clearPasswords(view);
        }

    }

    public void updateUserBirthday(Calendar calendar, EditText editText) {

        String dateFormat = "MM/dd/yy";

        SimpleDateFormat simpleDateFormatForDate = new SimpleDateFormat(dateFormat, Locale.US);

        editText.setText(simpleDateFormatForDate.format(calendar.getTime()));

    }


}
