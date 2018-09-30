package decisionmakingcontrolandroid.diu.com.examplenetworkproject;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    ArrayList<Student> studentsInfo = new ArrayList<>();
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading...");
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();

        myAdapter = new MyAdapter(studentsInfo, this);


    }

    class MyAsyncTask extends AsyncTask {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }

        @Override
        protected Object doInBackground(Object[] objects) {

            String stringUrl = "https://api.androidhive.info/contacts/";
            URL url = null;
            try {
                url = new URL(stringUrl);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                InputStream stream = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
                StringBuilder builder = new StringBuilder();

                String inputString;
                while ((inputString = bufferedReader.readLine()) != null) {
                    builder.append(inputString);
                }

                JSONObject rootObject = new JSONObject(builder.toString());
                JSONArray myContacts = rootObject.getJSONArray("contacts");
                for (int i = 0; i < myContacts.length(); i++) {
                    JSONObject jsonObject = (JSONObject) myContacts.get(i);
                    String id = jsonObject.getString("id");
                    String name = jsonObject.getString("name");
                    String email = jsonObject.getString("email");
                    String address = jsonObject.getString("address");
                    String gender = jsonObject.getString("gender");

                    JSONObject jsonObjectPhoneNo = jsonObject.getJSONObject("phone");
                    String mobile = jsonObjectPhoneNo.getString("mobile");
                    String home = jsonObjectPhoneNo.getString("home");
                    String office = jsonObjectPhoneNo.getString("office");

                    Student student = new Student(id, name, email, address, gender, mobile, home, office);

                    studentsInfo.add(student);
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            progressDialog.hide();
            myAdapter.notifyDataSetChanged();
        }

    }

}
