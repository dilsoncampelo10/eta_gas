package devandroid.dilson.appetagas.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import java.util.List;

import devandroid.dilson.appetagas.database.EtaGasDB;
import devandroid.dilson.appetagas.model.Fuel;
import devandroid.dilson.appetagas.view.MainActivity;

public class FuelController extends EtaGasDB {
    private SharedPreferences sharedPreferences;
    private static final String PREFERENCE_NAME = "pref_fuel";
    private SharedPreferences.Editor fuelList;

    public FuelController(MainActivity mainActivity){
        super(mainActivity);
        this.sharedPreferences = mainActivity.getSharedPreferences(PREFERENCE_NAME,0);
        this.fuelList = sharedPreferences.edit();
    }

    public void save(Fuel f){
        ContentValues content = new ContentValues();
        //SharedPreferences
        this.fuelList.putString("name",f.getName());
        this.fuelList.putString("price",f.getPrice().toString());
        this.fuelList.putString("msg",f.getMsg());
        this.fuelList.apply();
        //DB
        content.put("name",f.getName());
        content.put("price",f.getPrice());
        content.put("msg",f.getMsg());

        saveDB("fuel",content);
    }

    public void clear(){
        this.fuelList.clear();
        this.fuelList.apply();
    }

    public List<Fuel> getData(){
        return getDB();
    }

    public void update(Fuel fuel){
        ContentValues content = new ContentValues();
        content.put("id",fuel.getId());
        content.put("name",fuel.getName());
        content.put("price",fuel.getPrice());
        content.put("msg",fuel.getMsg());

        updateDB("fuel",content);
    }

    public void delete(Integer id){
        deleteDB("fuel",id);
    }

}
