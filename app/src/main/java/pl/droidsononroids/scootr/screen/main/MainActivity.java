package pl.droidsononroids.scootr.screen.main;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import butterknife.BindView;
import java.util.List;
import pl.droidsononroids.scootr.R;
import pl.droidsononroids.scootr.model.Scooter;
import pl.droidsononroids.scootr.mvp.BaseActivity;
import pl.droidsononroids.scootr.screen.main.feature.AddScooterDialogFeature;
import pl.droidsononroids.scootr.screen.main.feature.AddScooterFabFeature;
import pl.droidsononroids.scootr.screen.main.feature.MainFeatureHost;
import pl.droidsononroids.scootr.screen.main.feature.ScootersFeature;
import pl.droidsononroids.scootr.screen.main.feature.SnackBarFeature;
import pl.droidsononroids.scootr.screen.main.feature.ToolbarFeature;
import pl.droidsononroids.scootr.screen.main.list.ScooterListener;

public class MainActivity extends BaseActivity<MainFeatureHost, MainPresenter> implements MainView {
    @BindView(R.id.coordinator_layout) CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFeatureHost.dispatchOnCreate(mCoordinatorLayout, mPresenter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onCreate();
    }

    @Override
    protected void prepareFeatureHost() {
        mFeatureHost = new MainFeatureHost(this)
                .with(new ToolbarFeature())
                .with(new AddScooterFabFeature())
                .with(new AddScooterDialogFeature())
                .with(new SnackBarFeature())
                .with(new ScootersFeature());
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void showError(final String numberPlate) {
        mFeatureHost.dispatchOnAddScooterError(numberPlate);
    }

    @Override
    public void showScooters(final List<Scooter> scooterList, final ScooterListener scooterListener) {
        mFeatureHost.dispatchShowScooters(scooterList, scooterListener);
    }

    @Override
    public void addScooter(final Scooter scooter) {
        mFeatureHost.dispatchAddScooter(scooter);
    }
}
