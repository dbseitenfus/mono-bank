package com.ufsm.mono;

import androidx.annotation.DrawableRes;

public class Transference {
    @DrawableRes Integer imageDrawId;
    String name;
    String date;
    String value;

    public Transference(Integer imageDrawId, String name, String date, String value) {
        this.imageDrawId = imageDrawId;
        this.name = name;
        this.date = date;
        this.value = value;
    }
}
