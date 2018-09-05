package com.andrewxa.a11aretrofitloaderssample.ui;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.andrewxa.a11aretrofitloaderssample.R;
import com.andrewxa.a11aretrofitloaderssample.api.response.Response;
import com.andrewxa.a11aretrofitloaderssample.content.Airport;
import com.andrewxa.a11aretrofitloaderssample.loaders.sync.custom.AirportsLoaderRealm;

import java.util.List;


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Response> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLoaderManager().initLoader(R.id.realm_loader, Bundle.EMPTY, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Intent intent = new Intent(this,ContentProviderActivity.class);
                this.startActivity(intent);
                return true;
            default:
                return true;
        }
    }

    @Override
    public Loader<Response> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case R.id.realm_loader:
                return new AirportsLoaderRealm(this, "55.749792,37.6324949");

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
        }
        getLoaderManager().destroyLoader(id);
    }

    @Override
    public void onLoaderReset(Loader<Response> loader) {
        // Do nothing
    }
}
