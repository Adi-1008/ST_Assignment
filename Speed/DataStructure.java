package Speed;

import java.util.Random;

public class DataStructure {
    public double[] array;
    public int size;

    // Initialize array with random numbers

    public void setSize(int s)
    {
        this.size=s;
    }

    public void initArrayRandom(int size, int lower, int upper) {
        array = new double[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt((upper - lower) + 1) + lower;
        }
    }

    public void displayArray(double a[])
    {
        a = this.array;
        for(double i : a) System.out.print(i+" ");
        System.out.println();
    }

    public void displayArrayln(double a[])
    {
        a = this.array;
        for(double i : a) System.out.println(i);
    }

    public void setArray(double a[])
    {
        this.array=a;
    }
}