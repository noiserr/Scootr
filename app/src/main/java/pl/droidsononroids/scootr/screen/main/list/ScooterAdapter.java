package pl.droidsononroids.scootr.screen.main.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;
import pl.droidsononroids.scootr.R;
import pl.droidsononroids.scootr.model.Scooter;

public class ScooterAdapter extends RecyclerView.Adapter<ScooterAdapter.ScooterViewHolder> {

    private List<Scooter> mScooters = new ArrayList<>();
    private ScooterListener mScooterListener;

    public ScooterAdapter(final List<Scooter> scooters, final ScooterListener scooterListener) {
        mScooters = scooters;
        mScooterListener = scooterListener;
    }

    @Override
    public ScooterViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scooter_view, parent, false);
        return new ScooterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ScooterViewHolder holder, final int position) {
        final Scooter scooter = mScooters.get(position);
        holder.mFixed.setChecked(scooter.isFixed());
        holder.mDescription.setText(scooter.getDefect());
        holder.mPlate.setText(scooter.getNumberPlate());
        holder.mOwner.setText(scooter.getOwner());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View view) {
                removeItem(holder);
                return true;
            }
        });

        holder.mFixed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean isChecked) {
                final int position = holder.getAdapterPosition();
                final Scooter scooter = mScooters.get(position);
                scooter.setFixed(isChecked);
                mScooterListener.scooterChecked(scooter);
            }
        });
    }

    private void removeItem(final ScooterViewHolder holder) {
        final int position = holder.getAdapterPosition();
        final Scooter scooter = mScooters.get(position);
        mScooterListener.deleteScooter(scooter);
        mScooters.remove(mScooters.indexOf(scooter));
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return mScooters.size();
    }

    public void addScooter(final Scooter scooter) {
        mScooters.add(scooter);
        notifyItemInserted(mScooters.size()-1);
    }

    public class ScooterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.fixed_check_box) CheckBox mFixed;
        @BindView(R.id.scooter_plate_textview) TextView mPlate;
        @BindView(R.id.owner_text_view) TextView mOwner;
        @BindView(R.id.defect_text_view) TextView mDescription;

        public ScooterViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
