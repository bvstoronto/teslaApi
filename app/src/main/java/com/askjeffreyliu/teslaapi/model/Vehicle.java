package com.askjeffreyliu.teslaapi.model;

import com.orhanobut.logger.Logger;

import java.util.Arrays;
import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "vehicles_table")
public class Vehicle implements Cloneable {
    @NonNull
    @PrimaryKey(autoGenerate = false)
    private long id;

    @NonNull
    @ColumnInfo(name = "vehicle_id")
    private long vehicle_id;

    @NonNull
    @ColumnInfo(name = "vin")
    private String vin;

    @ColumnInfo(name = "display_name")
    private String display_name;

    @ColumnInfo(name = "option_codes")
    private String option_codes;

    @ColumnInfo(name = "color")
    private String color;

    @ColumnInfo(name = "state")
    private String state;

    @ColumnInfo(name = "in_service")
    private String in_service;

    @ColumnInfo(name = "id_s")
    private String id_s;

    @ColumnInfo(name = "remote_start_enabled")
    private boolean remote_start_enabled;

    @ColumnInfo(name = "calendar_enabled")
    private boolean calendar_enabled;

    @ColumnInfo(name = "notifications_enabled")
    private boolean notifications_enabled;

    @ColumnInfo(name = "backseat_token")
    private String backseat_token;

    @ColumnInfo(name = "backseat_token_updated_at")
    private String backseat_token_updated_at;


    //=======================
    @Ignore
    private Boolean isMobileAccessEnabled = null;

    @Ignore
    private ChargeStateResponseObj chargeStateResponseObj = null;
    //=======================


    public Vehicle(@NonNull long id, @NonNull long vehicle_id, @NonNull String vin) {
        this.id = id;
        this.vehicle_id = vehicle_id;
        this.vin = vin;
    }

    public Object clone() {
        try {
            Vehicle result = (Vehicle) super.clone();
//            result.setMobileAccessEnabled(isMobileAccessEnabled);
            if (getChargeStateResponseObj() == null) {
                result.setChargeStateResponseObj(null);
            } else {
                result.setChargeStateResponseObj((ChargeStateResponseObj) (getChargeStateResponseObj().clone()));
            }
            return result;
        } catch (CloneNotSupportedException e) {
            Logger.e(e.toString());
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Vehicle)
                && ((Vehicle) obj).values().equals(values());
    }

    private List<?> values() {
        return Arrays.asList(
                id,
                vehicle_id,
                vin,
                display_name,
                option_codes,
                color,
                state,
                in_service,
                id_s,
                remote_start_enabled,
                calendar_enabled,
                notifications_enabled,
                backseat_token,
                backseat_token_updated_at,
                isMobileAccessEnabled,
                chargeStateResponseObj
        );
    }

    @NonNull
    public long getId() {
        return id;
    }

    public void setId(@NonNull long id) {
        this.id = id;
    }

    @NonNull
    public long getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(@NonNull long vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    @NonNull
    public String getVin() {
        return vin;
    }

    public void setVin(@NonNull String vin) {
        this.vin = vin;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIn_service() {
        return in_service;
    }

    public void setIn_service(String in_service) {
        this.in_service = in_service;
    }

    public String getId_s() {
        return id_s;
    }

    public void setId_s(String id_s) {
        this.id_s = id_s;
    }

    public boolean isRemote_start_enabled() {
        return remote_start_enabled;
    }

    public void setRemote_start_enabled(boolean remote_start_enabled) {
        this.remote_start_enabled = remote_start_enabled;
    }

    public boolean isCalendar_enabled() {
        return calendar_enabled;
    }

    public void setCalendar_enabled(boolean calendar_enabled) {
        this.calendar_enabled = calendar_enabled;
    }

    public boolean isNotifications_enabled() {
        return notifications_enabled;
    }

    public void setNotifications_enabled(boolean notifications_enabled) {
        this.notifications_enabled = notifications_enabled;
    }

    public String getBackseat_token() {
        return backseat_token;
    }

    public void setBackseat_token(String backseat_token) {
        this.backseat_token = backseat_token;
    }

    public String getBackseat_token_updated_at() {
        return backseat_token_updated_at;
    }

    public void setBackseat_token_updated_at(String backseat_token_updated_at) {
        this.backseat_token_updated_at = backseat_token_updated_at;
    }

    public String getOption_codes() {
        return option_codes;
    }

    public void setOption_codes(String option_codes) {
        this.option_codes = option_codes;
    }

    //=======================

    public Boolean getMobileAccessEnabled() {
        return isMobileAccessEnabled;
    }

    public void setMobileAccessEnabled(Boolean mobileAccessEnabled) {
        isMobileAccessEnabled = mobileAccessEnabled;
    }

    public ChargeStateResponseObj getChargeStateResponseObj() {
        return chargeStateResponseObj;
    }

    public void setChargeStateResponseObj(ChargeStateResponseObj chargeStateResponseObj) {
        this.chargeStateResponseObj = chargeStateResponseObj;
    }
}
