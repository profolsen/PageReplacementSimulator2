import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

public class ExperimentDataGenerator {

    public static void main(String[] args) {
        try {
            generateData("accesses.txt", 5, 100, 100);
        } catch(Exception e) {
            System.err.println(e);
        }
    }
    /**
     * Generates some random page accesses.
     * @param filename where to store the accesses.
     * @param locality a parameter to adjust locality
     * @param length how many accesses
     * @param range the maximum page ID to generate.
     * @throws Exception if there are I/O problems. really bad practice.
     */
    public static void generateData(String filename, int locality, int length, int range) throws Exception{
        PrintStream ps = new PrintStream(new FileOutputStream(filename));
        LinkedList<Integer> accessQueue = new LinkedList<Integer>();
        for(int i = 0; i < length; i++) {
            int nextAccess;
            if(Math.random() < 0.1 || accessQueue.size() < 1) { //non-local access
                nextAccess = (int)(Math.random() * range);
            } else {
                int avg = 0;
                for(int x : accessQueue) avg += x;
                avg /= accessQueue.size();
                nextAccess = (int)(Math.random() * locality) + avg - locality / 2;
            } //local access.
            accessQueue.add(nextAccess);
            if(accessQueue.size() > locality) accessQueue.remove();
            ps.println(nextAccess);
        }
        ps.close();
    }
}
