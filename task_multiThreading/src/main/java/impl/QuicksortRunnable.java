package impl;

import util.Monitor;
import util.Partition;

public class QuicksortRunnable extends Monitor implements Runnable {

    protected Partition p;

    /**
     * Do not modify.
     * @param p Contains all information required for a recursion step.
     */
    public QuicksortRunnable(Partition p) {
        super(p);
        this.p = p;
    }

    @Override
    public void run() {
        if (p != null) {
            if (p.left < p.right) {
                int arr = p.array[p.right];
                int i = p.left - 1;

                for (int j = p.left; j < p.right; j++) {
                    if (p.array[j] <= arr) {
                        i++;
                        swap(p.array,i,j);
                    }
                }

                swap(p.array, i + 1, p.right);

                int temp = i + 1;

                Thread leftThread = new Thread(new QuicksortRunnable(new Partition(p.array, p.left, temp - 1)));
                Thread rightThread = new Thread(new QuicksortRunnable(new Partition(p.array, temp + 1, p.right)));

                leftThread.start();
                rightThread.start();

                try {
                    leftThread.join();
                    rightThread.join();
                } catch (InterruptedException e) {}
            }
        }
    }


    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
