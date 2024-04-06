package devandroid.dilson.appetagas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import devandroid.dilson.appetagas.model.Fuel;

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

    public void saveDB(String table, ContentValues content){
        db.insert(table,null,content);
    }

    public List<Fuel> getDB(){
        List<Fuel> fuels = new ArrayList<>();

        Fuel data;

        String query = "SELECT * FROM fuel";

        cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                data = new Fuel();
                data.setId(cursor.getInt(0));
                data.setName(cursor.getString(1));
                data.setPrice(cursor.getDouble(2));
                data.setMsg(cursor.getString(3));

                fuels.add(data);
            } while(cursor.moveToNext());
        }

        return fuels;
    }

    public void updateDB(String table, ContentValues content){
        Integer id = content.getAsInteger("id");

        db.update(table,content,"id=?",new String[]{Integer.toString(id)});
    }
}
