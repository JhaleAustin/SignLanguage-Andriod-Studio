package com.example.application;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity4 extends AppCompatActivity {


    private RecyclerView recyclerView;
    private SignAdapter signAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        recyclerView = findViewById(R.id.signsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        signAdapter = new SignAdapter();
        recyclerView.setAdapter(signAdapter);

        // Retrofit setup
        SignLanguageApiService apiService = RetrofitClient.getClient().create(SignLanguageApiService.class);
        Call<List<Sign>> call = apiService.getSigns();
        call.enqueue(new Callback<List<Sign>>() {
            @Override
            public void onResponse(Call<List<Sign>> call, Response<List<Sign>> response) {
                if (response.isSuccessful()) {
                    List<Sign> signList = response.body();
                    signAdapter.setData(signList);
                } else {
                    Toast.makeText(MainActivity4.this, "Error fetching sign data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Sign>> call, Throwable t) {
                Toast.makeText(MainActivity4.this, "Failed to connect to the server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
