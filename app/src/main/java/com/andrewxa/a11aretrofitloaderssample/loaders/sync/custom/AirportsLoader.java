package com.andrewxa.a11aretrofitloaderssample.loaders.sync.custom;

import android.content.Context;

import com.andrewxa.a11aretrofitloaderssample.api.AirportsService;
import com.andrewxa.a11aretrofitloaderssample.api.ApiFactory;
import com.andrewxa.a11aretrofitloaderssample.api.response.AirportsResponse;
import com.andrewxa.a11aretrofitloaderssample.api.response.RequestResult;
import com.andrewxa.a11aretrofitloaderssample.api.response.Response;
import com.andrewxa.a11aretrofitloaderssample.content.Airport;

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
    protected Response apiCall() throws IOException {
        AirportsService service = ApiFactory.getAirportsService();
        Call<List<Airport>> call = service.airports(mGps);
        List<Airport> airports = call.execute().body();
        return new AirportsResponse()
                .setRequestResult(RequestResult.SUCCESS)
                .setAnswer(airports);
    }
}

