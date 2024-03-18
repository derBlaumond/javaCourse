package lsg;

import util.AbstractAthlete;
import util.AbstractWeight;

public class Weight extends AbstractWeight {

    AbstractAthlete currentAthlete = null;

    public Weight(int id) {
        super(id);
    }

    @Override
    protected boolean pickUpImpl(AbstractAthlete athlete) {
        if(currentAthlete == null) {
            currentAthlete = athlete;
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected boolean putDownImpl(AbstractAthlete athlete) {
        if(currentAthlete != null && currentAthlete.equals(athlete)) {
            currentAthlete = null;
            notifyAll();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isAvailable() {
        return currentAthlete == null;
    }
}
