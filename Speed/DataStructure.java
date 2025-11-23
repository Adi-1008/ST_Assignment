package Speed;

import java.util.Random;

public class DataStructure {
    public int[] array;

    // Initialize array with random numbers
    public void initArrayRandom(int size, int lower, int upper) {
        array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt((upper - lower) + 1) + lower;
        }
    }
}