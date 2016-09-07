package pl.droidsononroids.scootr.screen.main.feature;

import android.app.Dialog;
import android.view.View;
import android.widget.EditText;
import com.yarolegovich.lovelydialog.LovelyCustomDialog;
import pl.droidsononroids.scootr.R;
import pl.droidsononroids.scootr.model.Scooter;

public class AddScooterDialogFeature extends MainFeature {
    private Dialog mDialog;

    @Override
    protected void addScooterFabClicked() {
        mDialog = new LovelyCustomDialog(mActivity)
                .setView(R.layout.add_scooter_dialog)
                .setIcon(R.drawable.ic_oil_temperature_white_36dp)
                .setTitle(R.string.ADD_SCOOTER)
                .setTopColorRes(R.color.colorPrimaryDark)
                .setListener(R.id.cancel, true, null)
                .setListener(R.id.add, true, new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        onDialogAddClicked();
                    }
                })
                .show();


    }

    private void onDialogAddClicked() {
        final EditText owner = (EditText) mDialog.findViewById(R.id.owner_edit_text);
        final EditText defect = (EditText) mDialog.findViewById(R.id.defect_edit_text);
        final EditText numberPlate = (EditText) mDialog.findViewById(R.id.number_plate_edit_text);

        final Scooter scooter = new Scooter();
        scooter.setOwner(getText(owner));
        scooter.setNumberPlate(getText(numberPlate));
        scooter.setDefect(getText(defect));

        mMainPresenter.addScooter(scooter);
    }

    private String getText(EditText editText) {
        return editText.getText().toString();
    }
}
