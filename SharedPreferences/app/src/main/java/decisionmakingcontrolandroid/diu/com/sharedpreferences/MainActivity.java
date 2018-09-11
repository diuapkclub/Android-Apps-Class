package decisionmakingcontrolandroid.diu.com.sharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText etNote;
    Button saveButton, viewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        initListeners();
    }

    private void initViews(){
        setContentView(R.layout.activity_main);
        etNote=findViewById(R.id.et_note);
        saveButton=findViewById(R.id.btn_save_note);
        viewButton=findViewById(R.id.btn_view_note);
    }

    private void initListeners(){
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myNote = etNote.getText().toString();
                String key = "note";

                AppPreference.getInstance(getApplicationContext()).setString(key, myNote);
                etNote.setText("");
                Toast.makeText(MainActivity.this, "Your Note Has Been Saved",
                        Toast.LENGTH_SHORT).show();

            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ShowNotes.class);
                startActivity(myIntent);
            }
        });
    }


}
