package pl.droidsononroids.scootr.screen.main.feature;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import de.halfbit.featured.Feature;
import de.halfbit.featured.FeatureEvent;
import java.util.List;
import pl.droidsononroids.scootr.model.Scooter;
import pl.droidsononroids.scootr.screen.main.MainPresenter;
import pl.droidsononroids.scootr.screen.main.list.ScooterListener;
import pl.droidsononroids.scootr.utils.Utils;

public class MainFeature extends Feature<MainFeatureHost> {

    protected AppCompatActivity mActivity;
    protected CoordinatorLayout mParent;
    protected MainPresenter mMainPresenter;

    @FeatureEvent
    protected void onCreate(@NonNull CoordinatorLayout parent, MainPresenter mainPresenter) {
        mParent = parent;
        mMainPresenter = mainPresenter;
        ButterKnife.bind(this, parent);
        mActivity = Utils.getActivity(parent.getContext());
    }

    @FeatureEvent
    protected void addScooterFabClicked() {
        //no-op
    }

    @FeatureEvent
    protected void onAddScooterError(String numberPlate) {
        //no-op
    }

    @FeatureEvent
    protected void showScooters(List<Scooter> scooters, ScooterListener scooterListener) {
        //no-op
    }

    @FeatureEvent
    protected void addScooter(Scooter scooter) {
        //no-op
    }
}
