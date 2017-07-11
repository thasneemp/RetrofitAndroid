package pro.muhammed.com.retrofitandroid.api;

import pro.muhammed.com.retrofitandroid.models.Details;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by muhammed on 7/11/2017.
 */

public interface ApiInterface {
    @GET("/contacts")
    Call<Details> getAllContacts();
}
