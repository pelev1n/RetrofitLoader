package com.andrewxa.a11aretrofitloaderssample.api.response;

import android.content.Context;
import android.support.annotation.NonNull;

import com.andrewxa.a11aretrofitloaderssample.content.Airport;
import com.andrewxa.a11aretrofitloaderssample.database.realm.AirportsHelper;

import java.util.List;

import io.realm.Realm;

/**
 * @author Artur Vasilov
 */
public class AirportsResponse extends Response {

    @Override
    public void save(@NonNull Context context) {
        List<Airport> airports = getTypedAnswer();
        if (airports != null) {
            AirportsHelper.save(Realm.getDefaultInstance(), airports);
        }
    }

    /*
    @Override
    public void save(Context context) {
        List<Airport> airports = getTypedAnswer();
        if (airports != null) {
            AirportsTable.save(context, airports);
        }
    }*/
}
