package com.example.user.retrofitdemo;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {
    TextView textview1,textview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview1=(TextView)findViewById(R.id.textview1);
        textview2=(TextView)findViewById(R.id.textview2);

        if (isOnline()) {
            ApiInterface apiService =
                    ApiClient.getClient().create(ApiInterface.class);

            Call<Model> call = apiService.getvalue();
            call.enqueue(new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {
                    Model model = response.body();
                    Log.e("TAG", "One:" + model.getOne());
                    Log.e("TAG", "Key:" + model.getKey());
                    textview1.setText("One:" + model.getOne());
                    textview2.setText("Key:" + model.getKey());

                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                    Toast.makeText(MainActivity.this, "" + t.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            Toast.makeText(MainActivity.this, "No Internet connection!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
