package pl.droidsononroids.scootr.screen.main;

import java.util.List;
import pl.droidsononroids.scootr.manager.ScooterManager;
import pl.droidsononroids.scootr.model.Scooter;
import pl.droidsononroids.scootr.mvp.BasePresenter;
import pl.droidsononroids.scootr.screen.main.list.ScooterListener;

public class MainPresenter extends BasePresenter<MainView> implements ScooterListener {
    private final ScooterManager mScooterManager;

    public MainPresenter(final MainView view) {
        super(view);
        mScooterManager = new ScooterManager();
    }

    public void addScooter(final Scooter scooter) {
        if (mScooterManager.addScooter(scooter)){
            mView.addScooter(scooter);
        }else {
            mView.showError(scooter.getNumberPlate());
        }
    }

    public void onCreate() {
        final List<Scooter> scooterList = mScooterManager.getScooters().getScooterList();
        mView.showScooters(scooterList, this);
    }

    @Override
    public void scooterChecked(final Scooter scooter) {
        mScooterManager.updateScooter(scooter);

    }

    @Override
    public void deleteScooter(final Scooter scooter) {
        mScooterManager.removeScooter(scooter);
    }
}
