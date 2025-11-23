import Speed.DataStructure;
import Speed.RunTime;
import Speed.Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MySpeedMulti {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("............ Welcome to Parallel Processing Environment+++++++++");

        System.out.println("Enter size of array");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter middle position of array");
        int mid = Integer.parseInt(br.readLine());
        System.out.println("Enter upper bound and lower bound (limit) of random numbers entered in the array");
        int lower = Integer.parseInt(br.readLine());
        int upper = Integer.parseInt(br.readLine());

        DataStructure ds = new DataStructure();
        ds.initArrayRandom(size, lower, upper);

        // Thread 1
        Sort s1 = new Sort(ds, "selection");
        s1.setStart(0);
        s1.setEnd(mid);
        Thread t1 = new Thread(s1);

        // Thread 2
        Sort s2 = new Sort(ds, "selection");
        s2.setStart(mid);
        s2.setEnd(size);
        Thread t2 = new Thread(s2);

        RunTime rt = new RunTime();
        rt.startTimer();
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Sort merger = new Sort(ds, "selection");
        merger.setMid(mid);
        merger.merge();

        rt.stopTimer();
        rt.print();
    }
}