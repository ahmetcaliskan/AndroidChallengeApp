package com.c.a.androidchallengeapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.c.a.androidchallengeapp.model.ModelOrders;
import com.c.a.androidchallengeapp.repository.RepositoryOrders;

import java.util.List;

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
