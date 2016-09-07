package pl.droidsononroids.scootr.screen.login.feature;

import android.widget.EditText;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;
import pl.droidsononroids.scootr.R;

public class LoginViewFeature extends LoginFeature {

    @BindView(R.id.login_edit_text) EditText mLoginEditText;
    @BindView(R.id.password_edit_text) EditText mPasswordEditText;
    @BindString(R.string.WRONG_PASSWORD) String mWrongPassword;


    @OnClick(R.id.login_button)
    public void onLoginButtonClicked(){
        final String login = mLoginEditText.getText().toString();
        final String password = mPasswordEditText.getText().toString();
        onLoginClick(login, password);
    }

    @Override
    protected void showLoginError() {
        mPasswordEditText.setError(mWrongPassword);
    }

    @Override
    protected void onLoginClick(final String login, final String password) {
        mLoginPresenter.performLogin(login, password);
    }
}
