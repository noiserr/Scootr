package pl.droidsononroids.scootr.mvp;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseActivity<FH, P extends BasePresenter> extends AppCompatActivity {

    protected FH mFeatureHost;
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        prepareFeatureHost();
        if (mPresenter == null)
            mPresenter = getPresenter();
    }

    protected abstract void prepareFeatureHost();

    @LayoutRes
    protected abstract int getLayout();

    protected abstract P getPresenter();
}
