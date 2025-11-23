package Speed;

public class Sort implements Runnable {
    DataStructure ds;
    String algorithm;
    int start;
    int end;
    int mid;

    public Sort(DataStructure ds, String algorithm) {
        this.ds = ds;
        this.algorithm = algorithm;
    }

    public void setStart(int start) { this.start = start; }
    public void setEnd(int end) { this.end = end; }
    public void setMid(int mid) { this.mid = mid; }

    // Part 1: Default Selection Sort
    public void selection() {
        int[] arr = ds.array;
        for (int i = start; i < end - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < end; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Part 3 (1): Added Bubble Sort Feature
    public void bubble() {
        int[] arr = ds.array;
        for (int i = start; i < end - 1; i++) {
            for (int j = start; j < end - (i - start) - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge logic for Parallel Mode
    public void merge() {
        int[] arr = ds.array;
        int n1 = mid; 
        int n2 = arr.length - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

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

    @Override
    public void run() {
        if (algorithm.equalsIgnoreCase("selection")) {
            selection();
        } else if (algorithm.equalsIgnoreCase("bubble")) {
            bubble();
        }
    }
}