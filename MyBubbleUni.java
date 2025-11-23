import Speed.DataStructure;
import Speed.RunTime;
import Speed.Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyBubbleUni {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("...........++++++++Welcome to Bubble Uni-Processing Environment+++++++++");
        
        System.out.println("Enter size of array");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter upper bound and lower bound (limit) of random numbers entered in the array");
        int lower = Integer.parseInt(br.readLine());
        int upper = Integer.parseInt(br.readLine());

        DataStructure ds = new DataStructure();
        ds.initArrayRandom(size, lower, upper);

        // Use "bubble" string to trigger bubble sort in core API
        Sort s = new Sort(ds, "bubble");
        s.setStart(0);
        s.setEnd(size);

        RunTime rt = new RunTime();
        rt.startTimer();
        s.bubble();
        rt.stopTimer();
        rt.print();
    }
}