package decisionmakingcontrolandroid.diu.com.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
     public static String DATABASE_NAME = "UserTest";
     public static final String TABLE_NAME = "student";
     public static  final String CULMN_ID = "id";
     public static  final String CULMN_1_NAME = "name";
     public static  final String CULMN_2_EMAIL= "email";
     public static  final String CULMN_3_NUMBER = "number";
    public DBHelper(Context context) {
        super(context,DATABASE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE ="CREATE TABLE IF NOT EXISTS "
                +TABLE_NAME+" ("+CULMN_ID+" INTEGER PRIMARY KEY, "+
                CULMN_1_NAME+" VARCHAR, "+
                CULMN_2_EMAIL+" VARCHAR, "+ CULMN_3_NUMBER +" VARCHAR)";

        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
