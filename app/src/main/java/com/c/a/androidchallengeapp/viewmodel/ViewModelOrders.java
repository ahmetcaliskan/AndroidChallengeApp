package com.c.a.androidchallengeapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.c.a.androidchallengeapp.model.ModelOrders;

import java.util.List;

import repository.RepositoryOrders;

public class ViewModelOrders extends AndroidViewModel {
    private MutableLiveData<List<ModelOrders>> listOrders;
    private RepositoryOrders repositoryOrders;

    public ViewModelOrders(@NonNull Application application) {
        super(application);
        repositoryOrders = new RepositoryOrders();
    }

    public MutableLiveData<List<ModelOrders>> getOrders() {
        return repositoryOrders.getOrders();
    }
}
