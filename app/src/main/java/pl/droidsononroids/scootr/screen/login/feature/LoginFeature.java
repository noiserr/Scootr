package pl.droidsononroids.scootr.screen.login.feature;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import de.halfbit.featured.Feature;
import de.halfbit.featured.FeatureEvent;
import pl.droidsononroids.scootr.screen.login.LoginPresenter;
import pl.droidsononroids.scootr.utils.Utils;

public class LoginFeature extends Feature<LoginFeatureHost> {

    private CoordinatorLayout mParent;
    protected AppCompatActivity mActivity;
    protected LoginPresenter mLoginPresenter;

    @FeatureEvent
    protected void onCreate(@NonNull CoordinatorLayout parent, LoginPresenter loginPresenter) {
        mParent = parent;
        mLoginPresenter = loginPresenter;
        ButterKnife.bind(this, parent);
        mActivity = Utils.getActivity(parent.getContext());
    }

    @FeatureEvent
    protected void onLoginClick(String login, String password) {
        //no-op
    }

    @FeatureEvent
    protected void showLoginError() {
        //no-op
    }

}
