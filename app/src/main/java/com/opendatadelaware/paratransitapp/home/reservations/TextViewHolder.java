package com.opendatadelaware.paratransitapp.home.reservations;

import android.view.View;
import android.widget.TextView;

import com.opendatadelaware.paratransitapp.R;

public class TextViewHolder extends BaseViewHolder {


    TextView textView;

    public TextViewHolder(View view) {
        super(view);

        textView = (TextView) view.findViewById(R.id.titleView);
    }
}
