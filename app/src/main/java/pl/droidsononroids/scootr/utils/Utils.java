package pl.droidsononroids.scootr.utils;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

public class Utils {

    public static AppCompatActivity getActivity(Context context) {
        if (!(context instanceof AppCompatActivity)) {
            throw new IllegalArgumentException("Context is not an activity");
        }
        return (AppCompatActivity) context;
    }

}
