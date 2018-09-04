package com.andrewxa.a11aretrofitloaderssample.ui;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.andrewxa.a11aretrofitloaderssample.R;
import com.andrewxa.a11aretrofitloaderssample.api.response.Response;
import com.andrewxa.a11aretrofitloaderssample.content.Airport;
import com.andrewxa.a11aretrofitloaderssample.loaders.sync.custom.AirportsLoader;

import java.util.List;


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Response> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLoaderManager().initLoader(R.id.airports_loader, Bundle.EMPTY, this);
    }

    @Override
    public Loader<Response> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case R.id.airports_loader:
                return new AirportsLoader(this, "55.749792,37.6324949");

            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Response> loader, Response data) {
        int id = loader.getId();
        if (id == R.id.airports_loader) {
            List<Airport> airports = data.getTypedAnswer();
            for(Airport airport : airports)
                System.out.println(airport.getName());
            //do something here
        }
        getLoaderManager().destroyLoader(id);
    }

    @Override
    public void onLoaderReset(Loader<Response> loader) {
        // Do nothing
    }
}
