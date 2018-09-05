package com.andrewxa.a11aretrofitloaderssample.loaders.async.cursor;

import android.content.Context;
import android.database.Cursor;

import com.andrewxa.a11aretrofitloaderssample.api.AirportsService;
import com.andrewxa.a11aretrofitloaderssample.api.ApiFactory;
import com.andrewxa.a11aretrofitloaderssample.api.RetrofitCallback;
import com.andrewxa.a11aretrofitloaderssample.content.Airport;
import com.andrewxa.a11aretrofitloaderssample.database.tables.AirportsTable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;


public class AirportsLoader extends BaseLoader {

    private final String mGps;

    private final AirportsService mAirportsService;

    public AirportsLoader(Context context, String gps) {
        super(context);
        mGps = gps;
        mAirportsService = ApiFactory.getAirportsService();
    }

    @Override
    protected void onForceLoad() {
        Call<List<Airport>> call = mAirportsService.airports(mGps);
        call.enqueue(new RetrofitCallback<List<Airport>>() {
            @Override
            public void onResponse(Call<List<Airport>> call, Response<List<Airport>> response) {
                if (response.isSuccessful()) {
                    AirportsTable.clear(getContext());
                    AirportsTable.save(getContext(), response.body());
                    Cursor cursor = getContext().getContentResolver().query(AirportsTable.URI,
                            null, null, null, null);
                    deliverResult(cursor);
                } else {
                    deliverResult(null);
                }
            }
        });
    }
}


