package pl.droidsononroids.scootr.screen.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import butterknife.BindView;
import pl.droidsononroids.scootr.R;
import pl.droidsononroids.scootr.mvp.BaseActivity;
import pl.droidsononroids.scootr.screen.login.feature.LoginFeatureHost;
import pl.droidsononroids.scootr.screen.login.feature.LoginViewFeature;
import pl.droidsononroids.scootr.screen.main.MainActivity;

public class LoginActivity extends BaseActivity<LoginFeatureHost, LoginPresenter> implements LoginView {

    @BindView(R.id.coordinator_layout) CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFeatureHost.dispatchOnCreate(mCoordinatorLayout, mPresenter);
    }

    @Override
    protected void prepareFeatureHost() {
        mFeatureHost = new LoginFeatureHost(this)
                .with(new LoginViewFeature());
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter getPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public void showNextActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void showLoginError() {
        mFeatureHost.dispatchShowLoginError();
    }
}
