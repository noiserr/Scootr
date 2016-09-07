package pl.droidsononroids.scootr.screen.main.feature;

import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;
import pl.droidsononroids.scootr.R;

public class SnackBarFeature extends MainFeature {

    @Override
    protected void onAddScooterError(final String numberPlate) {
        int errorBackgroundColor = ContextCompat.getColor(mParent.getContext(), R.color.colorError);
        int errorTextColor = ContextCompat.getColor(mParent.getContext(), android.R.color.white);
        final Snackbar snackbar = Snackbar.make(mParent, mParent.getContext().getString(R.string.ADD_SCOOTER_ERROR, numberPlate), Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(errorTextColor);
        ViewGroup group = (ViewGroup) snackbar.getView();
        group.setBackgroundColor(errorBackgroundColor);
        snackbar.show();
    }
}
