package pl.droidsononroids.scootr.screen.main.list;

import pl.droidsononroids.scootr.model.Scooter;

public interface ScooterListener {

    void deleteScooter(final Scooter scooter);

    void scooterChecked(Scooter scooter);
}
