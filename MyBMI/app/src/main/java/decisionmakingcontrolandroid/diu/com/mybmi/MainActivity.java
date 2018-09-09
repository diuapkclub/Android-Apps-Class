package decisionmakingcontrolandroid.diu.com.mybmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etHeight, etWeight;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeneres();
    }

    private void initViews(){
        etHeight=findViewById(R.id.etHeight);
        etWeight=findViewById(R.id.etWeight);
        submit=findViewById(R.id.btn_submit);
    }


    private void initListeneres(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int height, weight, result;
                height=Integer.valueOf(etHeight.getText().toString());
                weight=Integer.valueOf(etWeight.getText().toString());
                result =(weight/height)*703;

                if (result>0){
                    Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                    myIntent.putExtra("secret", result);
                    startActivity(myIntent);
                }else{
                    Toast.makeText(MainActivity.this, "Please give a valid input", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}
