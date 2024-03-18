package lsg;

public class Gym {

    /**
     * DO NOT CHANGE THE SIGNATURE OF THIS METHOD!
     *
     * Sets up the gym with the specified number of athletes and prepares them for specified number of training cycles.
     * If the specified number of athletes is smaller than 1, one athlete and two weights are created.
     * Otherwise, the number of weights is equal to the number of athletes. A weight is always shared by two athletes:
     * for the first athlete it's the left-hand weight, for the second athlete it's the right-hand weight.
     * @param numAthletes Number of athletes to be created.
     * @param cycles Number of training cycles, i.e. how many times each athlete should perform the training sequence.
     * @return Array of prepared athletes.
     */
    public static Athlete[] setup(int numAthletes, int cycles) {

        // make sure we have at least one athlete in our gym
        if(numAthletes < 1) {
            numAthletes = 1;
        }

        // if there is just one athlete, we need 2 weights, otherwise numWeights == numAthletes
        int numWeights = Math.max(numAthletes, 2);

        Athlete[] athletes = new Athlete[numAthletes];
        Weight[] weights = new Weight[numWeights];

        // create specified number of weights
        for(int i = 0; i < numWeights; i++) {
            weights[i] = new Weight(i);
        }

        // create specified number of athletes
        // a weight is shared by two athletes - for one it's the left weight, for the other the right weight
        for(int j = 0; j < numAthletes; j++) {
            athletes[j] = new Athlete(j, cycles, weights[j], weights[(j + 1) % numWeights]);
        }

        return athletes;
    }
}
