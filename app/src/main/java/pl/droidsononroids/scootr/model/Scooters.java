package pl.droidsononroids.scootr.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Scooters {
    private HashMap<String, Scooter> mScooters = new HashMap<>();

    public boolean addScooter(final Scooter scooter) {
        if (mScooters.containsKey(scooter.getNumberPlate())) {
            return false;
        }else {
            mScooters.put(scooter.getNumberPlate(), scooter);
            return true;
        }
    }

    public List<Scooter> getScooterList() {
        List<Scooter> scooters = new ArrayList<>();
        final Iterator iterator = mScooters.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry)iterator.next();
            scooters.add((Scooter) pair.getValue());
        }
        return scooters;
    }

    public void removeScooter(final Scooter scooter) {
        mScooters.remove(scooter.getNumberPlate());
    }

    public void updateScooter(final Scooter scooter) {
        mScooters.put(scooter.getNumberPlate(), scooter);
    }
}
