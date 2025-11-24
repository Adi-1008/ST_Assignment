package Speed;

public class Sort implements Runnable {
    DataStructure ds;
    String algorithm;
    private int start;
    private int end;
    private int mid;

    public Sort(DataStructure ds, String algorithm) {
        this.ds = ds;
        this.algorithm = algorithm;
    }

    public int getEnd() 
    {
        return this.end;
    }

    public int getStart()
    {
        return this.start;
    }

    public void setStart(int start) { this.start = start; }
    public void setEnd(int end) { this.end = end; }
    public void setMid(int mid) { this.mid = mid; }

    // Part 1: Default Selection Sort
    public void selection() {
        double[] arr = ds.array;
        for (int i = start; i < end - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < end; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }
            double temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Part 3 (1): Added Bubble Sort Feature
    public void bubble() {
        double[] arr = ds.array;
        for (int i = start; i < end - 1; i++) {
            for (int j = start; j < end - (i - start) - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge logic for Parallel Mode
    public void merge() {
        double[] arr = ds.array;
        int n1 = mid; 
        int n2 = arr.length - mid;
        double[] L = new double[n1];
        double[] R = new double[n2];

        for (int i = 0; i < n1; ++i) L[i] = arr[i];
        for (int j = 0; j < n2; ++j) R[j] = arr[mid + j];

        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) { arr[k] = L[i]; i++; }
            else { arr[k] = R[j]; j++; }
            k++;
        }
        while (i < n1) { arr[k] = L[i]; i++; k++; }
        while (j < n2) { arr[k] = R[j]; j++; k++; }
    }

    public int findMinPos(int start, int end)
    {
        double a[] = ds.array;
        double min = a[start];
        int min_idx = start;
        for(int i=start; i<end; i++)
        {
            if(a[i]<min)
            {
                min = a[i];
                min_idx=i;
            }
        }
        return min_idx;
    }

    @Override
    public void run() {
        if (algorithm.equalsIgnoreCase("selection")) {
            selection();
        } else if (algorithm.equalsIgnoreCase("bubble")) {
            bubble();
        }
    }
}