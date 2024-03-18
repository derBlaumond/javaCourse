package impl;

import util.Partition;

import java.io.File;
import java.util.Arrays;

public class Main {

    /**
     * Do not modify this method.
     */
    public static void main(String[] args) {
        int[] sortedArray = readAndSort("numbers.txt");
        System.out.println(Arrays.toString(sortedArray));
    }

    /**
     * Reads an array of integers from a given resource file using FileInput.readIntsFromFile and sorts the resulting
     * array using multi-threaded QuickSort provided by QuicksortRunnable.
     *
     * @param filePath Path to the file containing the integer array.
     * @return Sorted array of integers.
     */
    public static int[] readAndSort(String filePath) {
        //TODO: implement, do not change the signature!
        FileInput input = new FileInput();
        int[] arr = input.readIntsFromFile(filePath);
        Partition partition = new Partition(arr,0,arr.length -1);
        Thread sortThread = new Thread(new QuicksortRunnable(partition));
        sortThread.start();
        try {
            sortThread.join();
        } catch (InterruptedException e){}
        return arr;
    }
}
