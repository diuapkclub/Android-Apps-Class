package decisionmakingcontrolandroid.diu.com.mybmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    ImageView ivImageView;
    TextView tvBMI;
    Button btnTry;

    int result=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initViews();
        initVariables();
        initListeners();

    }


    private void initViews(){
        ivImageView=findViewById(R.id.ivImage);
        tvBMI=findViewById(R.id.tvResult);
        btnTry=findViewById(R.id.btnTryAgain);
    }

    private void initVariables(){
        result=getIntent().getIntExtra("secret",0);

        if (result>0){
            if(result<18){
                tvBMI.setText("Your BMI is "+result);
                ivImageView.setImageDrawable(getResources().getDrawable(R.drawable.healthy));
            }else{

                tvBMI.setText("Your BMI is "+result);
                ivImageView.setImageDrawable(getResources().getDrawable(R.drawable.unhealthy));
            }
        }else{
            Toast.makeText(this, "Technical Error", Toast.LENGTH_SHORT).show();
        }
    }

    private void initListeners(){
        btnTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
