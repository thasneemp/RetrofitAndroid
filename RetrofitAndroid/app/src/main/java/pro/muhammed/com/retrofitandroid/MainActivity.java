package pro.muhammed.com.retrofitandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pro.muhammed.com.retrofitandroid.adapters.ContactAdapter;
import pro.muhammed.com.retrofitandroid.api.ApiClient;
import pro.muhammed.com.retrofitandroid.api.ApiInterface;
import pro.muhammed.com.retrofitandroid.models.Details;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;


    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Details> allContacts = apiInterface.getAllContacts();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        allContacts.enqueue(new Callback<Details>() {
            @Override
            public void onResponse(Call<Details> call, Response<Details> response) {

                mRecyclerView.setAdapter(new ContactAdapter(MainActivity.this, response.body().getContacts()));

            }

            @Override
            public void onFailure(Call<Details> call, Throwable t) {

            }
        });
    }
}
