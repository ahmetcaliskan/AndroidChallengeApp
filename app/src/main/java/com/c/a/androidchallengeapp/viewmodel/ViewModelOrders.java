package com.c.a.androidchallengeapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.c.a.androidchallengeapp.model.ModelOrders;
import com.c.a.androidchallengeapp.repository.RepositoryOrders;

import java.util.List;

public class ViewModelOrders extends AndroidViewModel {
    private RepositoryOrders repositoryOrders;
    public ObservableField<List<ModelOrders>> listOrders;

    public ViewModelOrders(@NonNull Application application) {
        super(application);
        repositoryOrders = new RepositoryOrders();
        listOrders = new ObservableField<>();
    }

    public MutableLiveData<List<ModelOrders>> getOrders() {
        listOrders.set(repositoryOrders.getOrders().getValue());
        return repositoryOrders.getOrders();
    }
}
