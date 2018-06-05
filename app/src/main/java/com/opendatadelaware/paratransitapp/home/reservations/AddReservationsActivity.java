package com.opendatadelaware.paratransitapp.home.reservations;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.opendatadelaware.paratransitapp.MainActivity;
import com.opendatadelaware.paratransitapp.R;
import com.opendatadelaware.paratransitapp.home.HomeActivity;
import com.opendatadelaware.paratransitapp.model.Reservation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AddReservationsActivity extends AppCompatActivity {

    EditText tripTitle;
    EditText toTripPickupLocation;
    EditText toTripDestination;
    EditText toTripDateAndTime;

    EditText fromTripPickupLocation;
    EditText fromTripDateAndTime;
    EditText fromTripDestination;

    final Calendar toTripCalendar = Calendar.getInstance();
    final Calendar fromTripCalendar = Calendar.getInstance();

    TimePickerDialog toTripTimePicker;
    TimePickerDialog fromTripTimePicker;

    Button submitReservationButton;

    int hour;
    int minute;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addreservation);

        Toolbar toolbar = findViewById(R.id.addReservationsToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("ParaApp");

        tripTitle = findViewById(R.id.rideTitleEditText);
        toTripPickupLocation = findViewById(R.id.pickupLocationEditText);
        toTripDestination = findViewById(R.id.toTripDestinationTitleInput);
        toTripDateAndTime = findViewById(R.id.dateEditText);

        fromTripDateAndTime = findViewById(R.id.backTripTimeInput);
        fromTripPickupLocation = findViewById(R.id.fromTripPickupInput);
        fromTripDestination = findViewById(R.id.backTripDestinationInput);


        submitReservationButton = findViewById(R.id.submitButton);

        toTripTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                toTripCalendar.set(Calendar.HOUR, hourOfDay);
                toTripCalendar.set(Calendar.MINUTE, minute);

                updateEditText(toTripCalendar, toTripDateAndTime);
            }
        }, hour, minute, true);

        fromTripTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                fromTripCalendar.set(Calendar.HOUR, hourOfDay);
                fromTripCalendar.set(Calendar.MINUTE, minute);

                updateEditText(fromTripCalendar, fromTripDateAndTime);
            }
        }, hour, minute, true);


        final DatePickerDialog.OnDateSetListener toTripDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                toTripCalendar.set(Calendar.YEAR, year);
                toTripCalendar.set(Calendar.MONTH, year);
                toTripCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                toTripTimePicker.show();
            }
        };

        final DatePickerDialog.OnDateSetListener fromTripDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                fromTripCalendar.set(Calendar.YEAR, year);
                fromTripCalendar.set(Calendar.MONTH, year);
                fromTripCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                fromTripTimePicker.show();
            }
        };

        toTripDateAndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(AddReservationsActivity.this, toTripDateListener, toTripCalendar.get(Calendar.YEAR), toTripCalendar.get(Calendar.MONTH),
                        toTripCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        fromTripDateAndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(AddReservationsActivity.this, fromTripDateListener, fromTripCalendar.get(Calendar.YEAR), fromTripCalendar.get(Calendar.MONTH),
                        fromTripCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        submitReservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Reservation one = generateFromReservation();
                Reservation two = generateToReservation();
                ArrayList<Reservation> reservations = new ArrayList<>();
                reservations.add(one);
                reservations.add(two);

                Intent mainMenuIntent = new Intent(getApplicationContext(), HomeActivity.class);

                startActivity(mainMenuIntent);

            }
        });

    }

    public Reservation generateFromReservation() {
        String title = tripTitle.getText().toString() + " (Back)";
        String pickupLocation = fromTripPickupLocation.getText().toString();
        String destination = fromTripDestination.getText().toString();
        String dateAndTime = fromTripDateAndTime.getText().toString();
        Reservation fromReservation = new Reservation();
        fromReservation.setTitle(title);
        fromReservation.setPickupDestination(pickupLocation);
        fromReservation.setDropoffDestination(destination);
        fromReservation.setReservationTime(dateAndTime);

        return fromReservation;

    }

    public Reservation generateToReservation() {

        String title = tripTitle.getText().toString();
        String pickupLocation = toTripPickupLocation.getText().toString();
        String destination = toTripDestination.getText().toString();
        String dateAndTime = toTripDateAndTime.getText().toString();
        Reservation toReservation = new Reservation();
        toReservation.setTitle(title);
        toReservation.setPickupDestination(pickupLocation);
        toReservation.setDropoffDestination(destination);
        toReservation.setReservationTime(dateAndTime);

        return toReservation;

    }

    public void updateEditText(Calendar calendar, EditText editText) {
        String dateFormat = "MM/dd/yy";
        String timeFormat = "HH:mm";
        String formattedDateAndTime = "";

        SimpleDateFormat simpleDateFormatForDate = new SimpleDateFormat(dateFormat, Locale.US);

        Log.i("Calendar", calendar.getTime().toString());

        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);

        String hourAsString = String.valueOf(hour);
        String minuteAsString = "";

        if (minute < 10) {
            minuteAsString += "0" + String.valueOf(minute);
        } else {
            minuteAsString += String.valueOf(minute);
        }

        formattedDateAndTime += String.valueOf(hour) + ":" + String.valueOf(minute);

        formattedDateAndTime += " PM";

        formattedDateAndTime +=" on " + String.valueOf(month) + "/" + String.valueOf(day) + "/" + "18";

        editText.setText(formattedDateAndTime);

    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent backtoHomeIntent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(backtoHomeIntent);
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.place_toolbar_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.action_logout:
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }

    }

    private void logout() {
        Intent logoutIntent = new Intent(this, MainActivity.class);
        startActivity(logoutIntent);
    }
}
