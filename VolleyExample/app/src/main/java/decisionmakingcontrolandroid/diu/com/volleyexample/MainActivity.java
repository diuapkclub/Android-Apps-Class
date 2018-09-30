package decisionmakingcontrolandroid.diu.com.volleyexample;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import decisionmakingcontrolandroid.diu.com.volleyexample.model.Contact;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvContacts;
    private ProgressDialog progressDialog;
    private ArrayList<Contact> contactArrayList = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    private MyRecyclerViewAdapter myRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading...");


        rvContacts = findViewById(R.id.rv_contacts);
        layoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(contactArrayList, this);
        rvContacts.setLayoutManager(layoutManager);
        rvContacts.setAdapter(myRecyclerViewAdapter);

        makeNetworkRequest();
    }

    private void makeNetworkRequest(){
        progressDialog.show();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.androidhive.info/contacts/";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("NetworkCallTesting", response.toString());
                try {
                    JSONArray myContacts = response.getJSONArray("contacts");
                    for(int i=0; i<myContacts.length(); i++){
                        JSONObject indexObject = (JSONObject) myContacts.get(i);

                        String id = indexObject.getString("id");
                        String name = indexObject.getString("name");
                        String email = indexObject.getString("email");
                        String address = indexObject.getString("address");
                        String gender = indexObject.getString("gender");

                        JSONObject phone = indexObject.getJSONObject("phone");

                        String mobile = phone.getString("mobile");
                        String home = phone.getString("home");
                        String office = phone.getString("office");

                        ArrayList<String> phoneList = new ArrayList<>();
                        phoneList.add(0, mobile);
                        phoneList.add(1, home);
                        phoneList.add(2, office);

                        Contact contact = new Contact(id, name, email, address, gender, phoneList);
                        contactArrayList.add(contact);
                    }
                    myRecyclerViewAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                progressDialog.hide();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("NetworkCallTesting", error.toString());
                progressDialog.hide();
            }
        }
        );

        queue.add(jsonObjectRequest);
    }

//    private void showAllContacts(){
//        for(int i=0; i<contactArrayList.size(); i++){
//            Contact contact = contactArrayList.get(i);
//
//            String id = contact.getId();
//            String name = contact.getName();
//            String email = contact.getEmail();
//            String address = contact.getAddress();
//            String gender =  contact.getGender();
//
//            ArrayList phone = contact.getPhone();
//            String mobile = (String) phone.get(0);
//            String home = (String) phone.get(1);
//            String office = (String) phone.get(2);
//
//            Log.d("DataTesting", id+"  "+name+"  "+email+"  "+address+"  "+gender+"  "+mobile+"  "+home+"  "+office);
//        }
//    }


}
