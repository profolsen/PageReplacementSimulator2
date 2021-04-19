import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Experiment {
    public static void main(String[] args) {
        ArrayList<Integer> accesses = new ArrayList<Integer>();
        try {
            Scanner scan = new Scanner(new File("accesses.txt"));
            while(scan.hasNextLine()) {
                accesses.add(Integer.parseInt(scan.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int now = 0;
        Memory result_FPR = new Memory(8);
        result_FPR.setPageReplacementAglorithm(new FirstPageReplacementAlgorithm());
        for(int id : accesses) result_FPR.access(id, now++);
        System.out.println("First Page Replacement Page Faults: " + result_FPR.pageFaults());

        now = 0;
        Memory result_Random = new Memory(8);
        //set page replacement algorithm to random.
        for(int id : accesses) result_Random.access(id, now++);
        System.out.println("Random Page Replacement Page Faults: " + result_Random.pageFaults());

        now = 0;
        Memory result_FIFO = new Memory(8);
        //set page replacement algorithm to FIFO.
        for(int id : accesses) result_FIFO.access(id, now++);
        System.out.println("FIFO Page Replacement Page Faults: " + result_FIFO.pageFaults());

        now = 0;
        Memory result_LRU = new Memory(8);
        //set page replacement algorithm to Least Recently Used.
        for(int id : accesses) result_LRU.access(id, now++);
        System.out.println("Least Recently Used Page Replacement Page Faults: " + result_LRU.pageFaults());
    }
}
