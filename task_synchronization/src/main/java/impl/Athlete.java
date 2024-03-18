package impl;

import util.AbstractAthlete;
import util.AbstractWeight;

/**
 * DO NOT CHANGE THE SIGNATURE OF THIS CLASS!
 *
 * Represents an athlete in our gym. Extends AbstractAthlete, which in turn extends Thread.
 *
 * An athlete performs a number of training cycles. In each cycle, the following sequence is performed:
 *
 * - the athlete stretches,
 * - picks up both weights
 * - exercises,
 * - and puts down both weights.
 */
public class Athlete extends AbstractAthlete {

    public Athlete(int id, int cycles, AbstractWeight leftWeight, AbstractWeight rightWeight) {
        super(id, cycles, leftWeight, rightWeight);
        //TODO: implement
    }

    @Override
    public void run() {
        //TODO: implement
    }
}
