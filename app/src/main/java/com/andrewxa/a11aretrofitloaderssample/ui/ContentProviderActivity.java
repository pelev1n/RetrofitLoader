package com.andrewxa.a11aretrofitloaderssample.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SimpleCursorAdapter;

import com.andrewxa.a11aretrofitloaderssample.R;
import com.andrewxa.a11aretrofitloaderssample.loaders.async.cursor.AirportsLoader;

public class ContentProviderActivity extends AppCompatActivity implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor> {

    SimpleCursorAdapter simpleCursorAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cursor_async_activity);
        getSupportLoaderManager().initLoader(R.id.airports_loader, Bundle.EMPTY, ContentProviderActivity.this);
    }

    @Override
    public android.support.v4.content.Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
        return new AirportsLoader(this, "55.749792,37.6324949");
    }

    @Override
    public void onLoadFinished(@NonNull android.support.v4.content.Loader<Cursor> loader, Cursor cursor) {
        System.out.print("!!!!!!!!!!!!!!!!!!! ");
        System.out.println(cursor);
    }

    @Override
    public void onLoaderReset(@NonNull android.support.v4.content.Loader<Cursor> loader) {

    }

    }
