package devandroid.dilson.appetagas.controller;

import android.content.SharedPreferences;

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
        this.fuelList.putString("name",f.getName());
        this.fuelList.putString("price",f.getPrice().toString());
        this.fuelList.putString("msg",f.getMsg());
        this.fuelList.apply();
    }

    public void clear(){
        this.fuelList.clear();
        this.fuelList.apply();
    }

    public void getData(Fuel f){
        f.setName(sharedPreferences.getString("name",""));
        f.setPrice(Double.parseDouble(sharedPreferences.getString("price","")));
    }

}
