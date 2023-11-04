import java.util.*;

public class temp {
    public static void main(String[] args) {
        int no_of_processes;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Processes: ");
        no_of_processes = sc.nextInt();
        System.out.println("Enter Arrival time and burst time for each process\n");
        int bt[] = new int[no_of_processes];
        int at[] = new int[no_of_processes];

        for (int i = 0; i < no_of_processes; i++) {
            System.out.println("Enter the Arrival time of process " + (i + 1));
            at[i] = sc.nextInt();
            System.out.println("Enter the Burst time of process " + (i + 1));
            bt[i] = sc.nextInt();
        }

        SJF(at, bt, no_of_processes);
        sc.close();
    }

    private static void SJF(int[] at, int[] bt, int n) {
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        boolean completed[] = new boolean[n];
        int total = 0;
        int currentTime = 0;

        while (total < n) {
            int minBurstTime = Integer.MAX_VALUE;
            int shortestProcess = -1;

            for (int i = 0; i < n; i++) {
                if (!completed[i] && at[i] <= currentTime && bt[i] < minBurstTime) {
                    minBurstTime = bt[i];
                    shortestProcess = i;
                }
            }

            if (shortestProcess == -1) {
                currentTime++;
            } else {
                bt[shortestProcess]--;
                if (bt[shortestProcess] == 0) {
                    ct[shortestProcess] = currentTime + 1;
                    tat[shortestProcess] = ct[shortestProcess] - at[shortestProcess];
                    wt[shortestProcess] = tat[shortestProcess] - at[shortestProcess] - bt[shortestProcess];
                    completed[shortestProcess] = true;
                    total++;
                }
                currentTime++;
            }
        }

        System.out.println("Solution: \n");
        System.out.println("P#\t AT\t BT\t CT\t TAT\t WT\t\n");

        for (int k = 0; k < n; k++) {
            System.out.println((k + 1) + "\t" + at[k] + "\t" + bt[k] + "\t" + ct[k] + "\t" + tat[k] + "\t" + wt[k]);
        }
    }
}
