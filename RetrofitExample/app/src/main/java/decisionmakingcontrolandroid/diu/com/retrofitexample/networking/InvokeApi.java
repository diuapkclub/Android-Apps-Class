package decisionmakingcontrolandroid.diu.com.retrofitexample.networking;

import android.util.Log;

import java.util.ArrayList;

import decisionmakingcontrolandroid.diu.com.retrofitexample.MainActivity;
import decisionmakingcontrolandroid.diu.com.retrofitexample.model.Contact;
import decisionmakingcontrolandroid.diu.com.retrofitexample.model.MyContacts;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InvokeApi {

    public static void makeApiRequest(final MainActivity.NetWorkCallListener netWorkCallListener) {

        ApiInterface apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
        Call<MyContacts> myCall = apiInterface.findMyContacts();
        myCall.enqueue(new Callback<MyContacts>() {
            @Override
            public void onResponse(Call<MyContacts> call, Response<MyContacts> response) {
                Log.d("DataTesting", "onResponse");
                MyContacts myContacts = (MyContacts) response.body();
                ArrayList<Contact> contactArrayList = myContacts.getContacts();
                netWorkCallListener.onSuccess(contactArrayList);
            }

            @Override
            public void onFailure(Call<MyContacts> call, Throwable t) {
                Log.d("DataTesting", "onFailure");
                netWorkCallListener.onFailed();
            }
        });

    }


}
