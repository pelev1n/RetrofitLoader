package com.andrewxa.a11aretrofitloaderssample;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * @author Artur Vasilov
 */
public class AppDelegate extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
/*
        */
/*RealmConfiguration configuration = new Builder (this).build();
        Realm.setDefaultConfiguration(configuration);*//*

        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build();
*/

        Realm.init(getApplicationContext());

        // create your Realm configuration
        RealmConfiguration config = new RealmConfiguration.
                Builder().
                deleteRealmIfMigrationNeeded().
                build();
        Realm.setDefaultConfiguration(config);
    }
}
