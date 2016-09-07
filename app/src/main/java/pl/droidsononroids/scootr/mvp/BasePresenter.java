package pl.droidsononroids.scootr.mvp;

public class BasePresenter<V extends BaseView> {

    protected V mView;

    public BasePresenter(final V view) {
        mView = view;
    }
}
