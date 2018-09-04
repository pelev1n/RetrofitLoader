package com.andrewxa.a11aretrofitloaderssample.api;

import com.andrewxa.a11aretrofitloaderssample.content.Airport;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Artur Vasilov
 */
public interface AirportsService {

    @GET("/places/coords_to_places_ru.json")
    Call<List<Airport>> airports(@Query("coords") String gps);

}
