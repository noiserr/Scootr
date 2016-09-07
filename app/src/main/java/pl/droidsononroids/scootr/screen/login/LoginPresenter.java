package pl.droidsononroids.scootr.screen.login;

import pl.droidsononroids.scootr.manager.LoginManager;
import pl.droidsononroids.scootr.mvp.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(final LoginView view) {
        super(view);
    }

    public void performLogin(final String login, final String password) {
        if (LoginManager.login(login, password)){
            mView.showNextActivity();
        }else {
            mView.showLoginError();
        }
    }
}
