package com.c.a.androidchallengeapp.repository;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.c.a.androidchallengeapp.model.ModelOrders;
import com.c.a.androidchallengeapp.retrofit.ApiOrders;
import com.c.a.androidchallengeapp.retrofit.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryOrders {
    private ApiOrders apiOrders;
    private MutableLiveData<List<ModelOrders>> orders;

    public RepositoryOrders() {
        apiOrders = RetrofitInstance.createService(ApiOrders.class);
    }

    public MutableLiveData<List<ModelOrders>> getOrders() {
        orders = new MutableLiveData<>();

        Call<List<ModelOrders>> call = apiOrders.getOrders();
        call.enqueue(new Callback<List<ModelOrders>>() {
            @Override
            public void onResponse(@Nullable Call<List<ModelOrders>> call, @Nullable Response<List<ModelOrders>> response) {
                if (response != null && response.isSuccessful()) {
                    orders.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@Nullable Call<List<ModelOrders>> call, @Nullable Throwable t) {
                orders.setValue(null);
            }
        });

        return orders;
    }
}
