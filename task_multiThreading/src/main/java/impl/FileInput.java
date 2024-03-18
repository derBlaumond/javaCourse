package impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileInput {

    /**
     * Reads an array of integers from a resource file.
     * @param path Path to the file within the resources folder.
     * @return Array of integers.
     */
    public int[] readIntsFromFile(String path) {
        //TODO: implement, do not change the signature!

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        if (inputStream == null) {
            return new int[0];
        }

        List<Integer> numList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String string;
            while ((string = reader.readLine()) != null) {
                numList.add(Integer.parseInt(string));
            }
        } catch (IOException e) { return new int[0]; }

        int[] resultArr = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            resultArr[i] = numList.get(i);
        }

        return resultArr;
    }
}
