package com.ufsm.mono.model;

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

    public Integer getImageDrawId() {
        return imageDrawId;
    }

    public void setImageDrawId(Integer imageDrawId) {
        this.imageDrawId = imageDrawId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
