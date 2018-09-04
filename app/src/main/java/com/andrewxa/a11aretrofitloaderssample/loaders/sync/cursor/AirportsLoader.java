package com.andrewxa.a11aretrofitloaderssample.loaders.sync.cursor;

import android.content.Context;
import android.database.Cursor;

import com.andrewxa.a11aretrofitloaderssample.api.AirportsService;
import com.andrewxa.a11aretrofitloaderssample.api.ApiFactory;
import com.andrewxa.a11aretrofitloaderssample.content.Airport;
import com.andrewxa.a11aretrofitloaderssample.database.tables.AirportsTable;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;


/**
 * @author Artur Vasilov
 */
public class AirportsLoader extends BaseLoader {

    private final String mGps;

    public AirportsLoader(Context context, String gps) {
        super(context);
        mGps = gps;
    }

    @Override
    protected Cursor apiCall() throws IOException {
        AirportsService service = ApiFactory.getAirportsService();
        Call<List<Airport>> call = service.airports(mGps);
        List<Airport> airports = call.execute().body();
        AirportsTable.save(getContext(), airports);
        return getContext().getContentResolver().query(AirportsTable.URI,
                null, null, null, null);
    }
}


