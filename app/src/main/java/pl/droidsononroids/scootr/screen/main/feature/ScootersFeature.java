package pl.droidsononroids.scootr.screen.main.feature;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import java.util.List;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import pl.droidsononroids.scootr.R;
import pl.droidsononroids.scootr.model.Scooter;
import pl.droidsononroids.scootr.screen.main.MainPresenter;
import pl.droidsononroids.scootr.screen.main.list.ScooterAdapter;
import pl.droidsononroids.scootr.screen.main.list.ScooterListener;

public class ScootersFeature extends MainFeature {

    @BindView(R.id.scooters_recycler_view) RecyclerView mRecyclerView;
    private ScooterAdapter mScooterAdapter;
    private int mScooterListSize;

    @Override
    protected void onCreate(@NonNull final CoordinatorLayout parent, final MainPresenter mainPresenter) {
        super.onCreate(parent, mainPresenter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(parent.getContext()));
    }

    @Override
    protected void showScooters(final List<Scooter> scooters, ScooterListener scooterListener) {
        mScooterListSize = scooters.size();
        mScooterAdapter = new ScooterAdapter(scooters, scooterListener);
        mRecyclerView.setAdapter(new ScaleInAnimationAdapter(mScooterAdapter));
    }

    @Override
    protected void addScooter(final Scooter scooter) {
        mScooterAdapter.addScooter(scooter);
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.smoothScrollToPosition(++mScooterListSize);
            }
        }, 50);
    }
}
