package decisionmakingcontrolandroid.diu.com.retrofitexample.networking;

import decisionmakingcontrolandroid.diu.com.retrofitexample.model.MyContacts;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("contacts/")
    Call<MyContacts> findMyContacts();

}
