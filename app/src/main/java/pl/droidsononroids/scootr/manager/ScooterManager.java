package pl.droidsononroids.scootr.manager;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import pl.droidsononroids.scootr.ScootrApp;
import pl.droidsononroids.scootr.model.Scooter;
import pl.droidsononroids.scootr.model.Scooters;

public class ScooterManager {

    private final SharedPreferences mSharedPreferences;
    private final Gson mGson;

    public ScooterManager() {
        mGson = new Gson();
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(ScootrApp.getContext());
    }

    public Scooters getScooters() {
        Scooters scooters;
        try {
            final String json = mSharedPreferences.getString(PrefsConstants.SCOOTERS, PrefsConstants.NO_SCOOTERS);
            System.out.println(json);
            scooters =  mGson.fromJson(json, Scooters.class);
        } catch (JsonSyntaxException e) {
            scooters =  new Scooters();
        }
        return scooters;
    }

    public void saveScooters(Scooters scooters) {
        mSharedPreferences.edit().putString(PrefsConstants.SCOOTERS, mGson.toJson(scooters)).apply();
    }

    public boolean addScooter(Scooter scooter) {
        final Scooters scooters = getScooters();
        final boolean result = scooters.addScooter(scooter);
        saveScooters(scooters);
        return result;
    }

    public void removeScooter(final Scooter scooter) {
        final Scooters scooters = getScooters();
        scooters.removeScooter(scooter);
        saveScooters(scooters);
    }

    public void updateScooter(final Scooter scooter) {
        final Scooters scooters = getScooters();
        scooters.updateScooter(scooter);
        saveScooters(scooters);
    }

    private interface PrefsConstants{
        String SCOOTERS = "SCOOTERS";
        String NO_SCOOTERS = "{\"mScooters\":{\""
                + "XK HJ44 K\":{\"mDefect\":\"Front light not working\",\"mFixed\":false,\"mNumberPlate\":\"XK HJ44 K\",\"mOwner\":\"Mr Smith\"},\""
                + "IJ 65K9 P\":{\"mDefect\":\"Breaks not working\",\"mFixed\":false,\"mNumberPlate\":\"IJ 65K9 P\",\"mOwner\":\"Mr Smith\"}}}";
    }
}
