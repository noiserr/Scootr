package pl.droidsononroids.scootr.screen.main.feature;

import butterknife.OnClick;
import pl.droidsononroids.scootr.R;

public class AddScooterFabFeature extends MainFeature {

    @OnClick(R.id.add_scooter)
    public void onAddScooterClicked(){
        getFeatureHost().dispatchAddScooterFabClicked();
    }
}
