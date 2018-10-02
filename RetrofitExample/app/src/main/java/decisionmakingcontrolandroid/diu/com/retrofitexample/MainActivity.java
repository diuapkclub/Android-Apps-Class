package decisionmakingcontrolandroid.diu.com.retrofitexample;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import decisionmakingcontrolandroid.diu.com.retrofitexample.model.Contact;
import decisionmakingcontrolandroid.diu.com.retrofitexample.model.Phone;
import decisionmakingcontrolandroid.diu.com.retrofitexample.networking.InvokeApi;

public class MainActivity extends AppCompatActivity {

    Button button;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading ....");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                InvokeApi.makeApiRequest(new NetWorkCallListener() {
                    @Override
                    public void onSuccess(ArrayList<Contact> contactArrayList) {
                        for(int i=0; i<contactArrayList.size(); i++){
                            Contact contact = contactArrayList.get(i);
                            String id = contact.getId();
                            String name = contact.getName();
                            String email = contact.getEmail();
                            String address = contact.getAddress();
                            String gender = contact.getGender();

                            Phone phone = contact.getPhone();
                            String mobile = phone.getMobile();
                            String home = phone.getHome();
                            String office = phone.getOffice();

                            Log.d("DataTesting", id+"  "+name);
                        }
                        progressDialog.hide();
                    }

                    @Override
                    public void onFailed() {
                        progressDialog.hide();
                    }
                });
            }
        });
    }


  public interface NetWorkCallListener{
        void onSuccess(ArrayList<Contact> contacts);
        void onFailed();
  }

}




