package decisionmakingcontrolandroid.diu.com.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String UserName = "";
    private EditText etName,etEmail,etNumber;
    private Button btnSubmit;
    private SQLiteDatabase sqLiteDatabase;
    private DBHelper dbHelper;
    private Cursor cursor;
    String NameHolder,EmailHolder,NumberHolder;
    boolean emptyTextHolder ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName  = findViewById(R.id.et_name);
        etEmail  = findViewById(R.id.et_Email);
        etNumber  = findViewById(R.id.et_Number);
        btnSubmit = findViewById(R.id.btn_submit);
        dbHelper = new DBHelper(this);



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckEditText();
                LoginFunction();
            }
        });

    }
    public void LoginFunction(){

        if(emptyTextHolder) {

            // Opening SQLite database write permission.
            sqLiteDatabase = dbHelper.getWritableDatabase();

            // Adding search name query to cursor.
            cursor = sqLiteDatabase.query(DBHelper.TABLE_NAME,
                    null, " " + DBHelper.CULMN_1_NAME +
                            "=?", new String[]{NameHolder},
                    null, null, null);

            while (cursor.moveToNext()) {

                if (cursor.isFirst()) {
                    cursor.moveToFirst();
                    // Closing cursor.
                    cursor.close();
                }
            }

            Toast.makeText(this, "Save Data", Toast.LENGTH_SHORT).show();


            // Calling method to check final result ..
            CheckFinalResult();

        }
        else {

            //If any of login EditText empty then this block will be executed.
            Toast.makeText(MainActivity.this,
                    "Please Enter UserName or Email and Number.", Toast.LENGTH_LONG).show();

        }

    }

    public  void  CheckEditText(){
        NameHolder = etName.getText().toString();
        EmailHolder = etEmail.getText().toString();
        NameHolder = etNumber.getText().toString();

        if (TextUtils.isEmpty(NameHolder)||TextUtils.isEmpty(EmailHolder)||TextUtils.isEmpty(NumberHolder)){
            emptyTextHolder = false;
        }else{

            emptyTextHolder = true;
        }



    }

    public void CheckFinalResult(){

        Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_LONG).show();

        // Going to Result activity after login success message.
        Intent intent = new Intent(MainActivity.this,
                ResultActivity.class);
        intent .putExtra(UserName,NameHolder);
        startActivity(intent);
    }


    }
