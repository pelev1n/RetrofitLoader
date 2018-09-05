package com.andrewxa.a11aretrofitloaderssample.database.realm;

import android.support.annotation.NonNull;

import com.andrewxa.a11aretrofitloaderssample.content.Airport;

import java.util.List;

import io.realm.Realm;

public class AirportsHelper {

    public static void save(@NonNull Realm realm, List<Airport> airports) {
        realm.beginTransaction();
        realm.delete(Airport.class);
        realm.copyToRealm(airports);
        realm.commitTransaction();
    }

    @NonNull
    public static List<Airport> getAirports(@NonNull Realm realm) {
        return realm.where(Airport.class).findAll();
    }
}
