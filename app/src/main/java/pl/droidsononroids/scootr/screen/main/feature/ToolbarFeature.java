package pl.droidsononroids.scootr.screen.main.feature;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import butterknife.BindString;
import butterknife.BindView;
import pl.droidsononroids.scootr.R;
import pl.droidsononroids.scootr.screen.main.MainPresenter;

public class ToolbarFeature extends MainFeature {

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindString(R.string.app_name) String title;


    @Override
    protected void onCreate(@NonNull final CoordinatorLayout parent, final MainPresenter mainPresenter) {
        super.onCreate(parent, mainPresenter);
        mActivity.setSupportActionBar(mToolbar);
        mActivity.getSupportActionBar().setTitle(title);
    }
}
