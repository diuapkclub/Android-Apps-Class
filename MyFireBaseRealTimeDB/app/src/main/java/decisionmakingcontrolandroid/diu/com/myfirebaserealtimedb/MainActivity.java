package decisionmakingcontrolandroid.diu.com.myfirebaserealtimedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "FireBaseDbTesting";
    FirebaseDatabase database;
    DatabaseReference myRef;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_message);
        editText = findViewById(R.id.et_message);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("users");

        User user = new User("Susan", "susan@gmail.com", "0178541654");

        final String userId = myRef.push().getKey();
        myRef.child(userId).setValue(user);

//        // Read from the database
        myRef.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                User user = dataSnapshot.getValue(User.class);
                textView.setText(user.getUserName()+" "+user.getUserEmail());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
//
//
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                myRef.setValue(s.toString());
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                // TODO Auto-generated method stub
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//                // TODO Auto-generated method stub
//            }
//        });

    }
}
