package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
//      int[] Ns = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        AList<Integer> Ns = new AList<>();
        int base = 1000;
        for (int i = 0; i < 8; i ++) {
            Ns.addLast(base);
            base = base * 2;
        }
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        for (int i = 0; i < Ns.size(); i ++) {
            AList<Integer> al = new AList<>();

            Stopwatch sw = new Stopwatch();
            int count = 0;
            for (int j = 0; j < Ns.get(i); j ++) {
                al.addLast(1);
                count ++;
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
            opCounts.addLast(count);
        }

        printTimingTable(Ns, times, opCounts);
    }
}
