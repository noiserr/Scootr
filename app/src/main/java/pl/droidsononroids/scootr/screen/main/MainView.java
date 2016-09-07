package pl.droidsononroids.scootr.screen.main;

import java.util.List;
import pl.droidsononroids.scootr.model.Scooter;
import pl.droidsononroids.scootr.mvp.BaseView;
import pl.droidsononroids.scootr.screen.main.list.ScooterListener;

public interface MainView extends BaseView {

    void showError(String numberPlate);

    void showScooters(List<Scooter> scooterList, ScooterListener scooterListener);

    void addScooter(Scooter scooter);
}
