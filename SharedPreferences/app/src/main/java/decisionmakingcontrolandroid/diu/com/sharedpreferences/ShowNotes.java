package decisionmakingcontrolandroid.diu.com.sharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowNotes extends AppCompatActivity {


    TextView myNote;
    Button addMoreButton;
    String key = "note";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        initVariables();
        initListeners();
    }

    private void initViews(){
        setContentView(R.layout.activity_show_notes);
        myNote=findViewById(R.id.tv_note);
        addMoreButton=findViewById(R.id.btn_add_new);

    }

    private void initVariables(){
       String myNoteText = AppPreference.getInstance(getApplicationContext()).getString(key);

       myNote.setText(myNoteText);
    }

    private void initListeners(){
        addMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ShowNotes.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
