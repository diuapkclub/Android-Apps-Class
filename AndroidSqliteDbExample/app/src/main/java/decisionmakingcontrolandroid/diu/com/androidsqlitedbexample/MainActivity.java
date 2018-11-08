package decisionmakingcontrolandroid.diu.com.androidsqlitedbexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setProgramToDb();
        getProgramFromDb();

    }

    private void setProgramToDb(){
        try {
            ProgramDbController favouriteController = new ProgramDbController(this);
            favouriteController.open();
            Program program = createPrograms(1);
            favouriteController.insertFavouriteItem(program.getProgramId(), program.getProgramName(), program.getProgramHostName(), program.getProgramStartTime(), program.getProgramEndTime(), program.getProgramDuration());
            favouriteController.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getProgramFromDb(){
        try {
            ProgramDbController favouriteController = new ProgramDbController(this);
            favouriteController.open();
            Program program = favouriteController.getAllProgramData().get(0);
            Toast.makeText(this, ""+program.getProgramName(), Toast.LENGTH_SHORT).show();
            Log.d("DatabaseTesting", program.getProgramId()+" "+program.getProgramName());
            favouriteController.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Program createPrograms(int i){

        Program program = new Program(i, "Program Name "+i, "Program Host Name "+i, "Program Time "+i, "Program End Time "+i, "Program Duration "+i);
        return program;
    }




}
