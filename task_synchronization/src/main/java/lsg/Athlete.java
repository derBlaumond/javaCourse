package lsg;

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
    }

    @Override
    public void run() {
        for(int i = 0; i < cycles; i++) {
            //System.out.println("Athlete " + this.id + " ready.");

            stretch();

            if(id % 2 == 0) {
                pickUpWeights(leftWeight, rightWeight);
            } else {
                pickUpWeights(rightWeight, leftWeight);
            }

            exercise();

            leftWeight.putDown(this);
            rightWeight.putDown(this);

            //System.out.println("Athlete " + this.id + " done.");
        }
    }

    private void pickUpWeights(AbstractWeight firstWeight, AbstractWeight secondWeight) {
        synchronized (firstWeight) {
            while(!firstWeight.isAvailable()) {
                try {
                    //System.out.println("Athlete " + id + " is waiting for weight " + firstWeight.getWeightId());
                    firstWeight.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            firstWeight.pickUp(this);
        }

        synchronized (secondWeight) {
            while(!secondWeight.isAvailable()) {
                try {
                    //System.out.println("Athlete " + id + " is waiting for weight " + secondWeight.getWeightId());
                    secondWeight.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            secondWeight.pickUp(this);
        }
    }
}
