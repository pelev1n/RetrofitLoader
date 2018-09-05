package com.andrewxa.a11aretrofitloaderssample;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class AppDelegate extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());

        // create your Realm configuration
        RealmConfiguration config = new RealmConfiguration.
                Builder().
                deleteRealmIfMigrationNeeded().
                build();
        Realm.setDefaultConfiguration(config);
    }
}
