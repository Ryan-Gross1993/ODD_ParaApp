package com.opendatadelaware.paratransitapp.model;

public enum State {
    AK, AL, AZ, AR, CA, CO, CT, DE, FL, GA, HI, ID, IL, IN, IA, KS, KY, LA, ME, MD, MA, MI, MN, MS, MO, MT
    , NE, NV, NH, NJ, NM, NY, NC, ND, OH, OK, OR, PA, RI, SC, SD, TN, TX, UT, VT, VA, WA, WV, WI, WY;

    public static String[] toStringArray() {

        State[] stateArray = State.values();

        String[] placeholder = new String[50];

        for (int i = 0; i < stateArray.length; i++) {

            placeholder[i] = stateArray[i].toString();
        }

        return placeholder;
    }

}
