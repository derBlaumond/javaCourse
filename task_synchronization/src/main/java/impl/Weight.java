package impl;

import util.AbstractAthlete;
import util.AbstractWeight;

public class Weight extends AbstractWeight {


    public Weight(int id) {
        super(id);
    }

    @Override
    public boolean isAvailable() {
        //TODO: implement
        return false;
    }

    @Override
    protected boolean pickUpImpl(AbstractAthlete athlete) {
        //TODO: implement
        return false;
    }

    @Override
    protected boolean putDownImpl(AbstractAthlete athlete) {
        //TODO: implement
        return false;
    }
}
