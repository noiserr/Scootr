package pl.droidsononroids.scootr.model;

public class Scooter {

    private String mNumberPlate;
    private String mOwner;
    private String mDefect;
    private boolean mFixed;

    public String getNumberPlate() {
        return mNumberPlate;
    }

    public void setNumberPlate(final String numberPlate) {
        mNumberPlate = numberPlate;
    }

    public String getOwner() {
        return mOwner;
    }

    public void setOwner(final String owner) {
        mOwner = owner;
    }

    public String getDefect() {
        return mDefect;
    }

    public void setDefect(final String defect) {
        mDefect = defect;
    }

    public boolean isFixed() {
        return mFixed;
    }

    public void setFixed(final boolean fixed) {
        mFixed = fixed;
    }
}
