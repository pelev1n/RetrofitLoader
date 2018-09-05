package com.andrewxa.a11aretrofitloaderssample.loaders;

import android.content.Context;
import android.content.CursorLoader;
import android.net.Uri;


public class LocalAirportsLoader extends CursorLoader {

    public LocalAirportsLoader(Context context, Uri uri,
                               String[] projection, String selection,
                               String[] selectionArgs, String sortOrder) {
        super(context, uri, projection, selection, selectionArgs, sortOrder);
    }
}


