package retrofit;

import com.c.a.androidchallengeapp.model.ModelOrders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiOrders {
    @GET("/")
    Call<List<ModelOrders>> getOrders();
}
