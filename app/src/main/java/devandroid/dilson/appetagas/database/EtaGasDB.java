package devandroid.dilson.appetagas.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class EtaGasDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "etagas.db";
    public static final int DB_VERSION = 1;
    public static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";

    Cursor cursor;
    SQLiteDatabase db;

    public EtaGasDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.i("nameDB",getDatabaseName());
        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String table
                = "CREATE TABLE fuel (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "price REAL, " +
                "msg TEXT)";

       db.execSQL(table);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
