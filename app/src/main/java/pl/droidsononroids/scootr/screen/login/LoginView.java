package pl.droidsononroids.scootr.screen.login;

import pl.droidsononroids.scootr.mvp.BaseView;

public interface LoginView extends BaseView {
    void showNextActivity();

    void showLoginError();
}
