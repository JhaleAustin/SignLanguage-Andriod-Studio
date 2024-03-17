package com.example.application;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface SignLanguageApiService {
    @GET("signs")
    Call<List<Sign>> getSigns();
}