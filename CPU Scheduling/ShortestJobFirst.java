import java.util.*;

//Premptive
public class ShortestJobFirst {
    public static void main(String[] args) {
        int no_of_processes;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of Processes : ");
        no_of_processes = sc.nextInt();
        System.out.println("Enter Arival time and burst time for each process\n");
        int bt[] = new int[no_of_processes];
        int at[] = new int[no_of_processes];

        for (int i = 0; i < no_of_processes; i++) {
            System.out.println("Enter the Arrival time of process " + (i + 1));
            at[i] = sc.nextInt();
            System.out.println("Enter the Brust time of process " + (i + 1));
            bt[i] = sc.nextInt();
        }
        SJF(at, bt, no_of_processes);
        sc.close();
    }

    private static void SJF(int[] at, int[] bt, int n) {
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        boolean fg[] = new boolean[n]; // flags for checking if process is completed or not
        int total = 0;
        int current_time = 0;
        int remainingBurst[] = new int[n];

        for (int i = 0; i < n; i++) {
            remainingBurst[i] = bt[i];
        }

        while (total < n) {
            int minBurstTime = Integer.MAX_VALUE;
            int shortestProcess = -1;

            for (int i = 0; i < n; i++) {
                if (!fg[i] && at[i] <= current_time && bt[i] < minBurstTime) {
                    minBurstTime = remainingBurst[i];
                    shortestProcess = i;
                }
            }

            if (shortestProcess == -1) {
                current_time++;
            } else {
                remainingBurst[shortestProcess]--;
                if (remainingBurst[shortestProcess] == 0) {
                    ct[shortestProcess] = current_time + 1;
                    tat[shortestProcess] = ct[shortestProcess] - at[shortestProcess];
                    wt[shortestProcess] = tat[shortestProcess] - bt[shortestProcess];
                    fg[shortestProcess] = true;
                    total++;
                }
                current_time++;
            }
        }

        System.out.println("Solution: \n\n");
        System.out.println("P#\t AT\t BT\t CT\t TAT\t WT\t\n\n");

        for (int k = 0; k < n; k++) {
            System.out.println((k + 1) + "\t" + at[k] + "\t" + bt[k] + "\t" + ct[k] + "\t" + tat[k] + "\t" + wt[k]);
        }
    }

}

// for testing
// n= 4
// at=[0,1,2,4]
// bt=[5,3,4,1]

// Non - premeptive

// import java.util.*;

// public class ShortestJobFirst {
// public static void main(String[] args) {
// int no_of_processes;
// Scanner sc = new Scanner(System.in);
// System.out.println("Enter the no of Processes : ");
// no_of_processes = sc.nextInt();
// System.out.println("Enter Arival time and burst time for each process\n");
// int bt[] = new int[no_of_processes];
// int at[] = new int[no_of_processes];

// for (int i = 0; i < no_of_processes; i++) {
// System.out.println("Enter the Arrival time of process " + (i + 1));
// at[i] = sc.nextInt();
// System.out.println("Enter the Brust time of process " + (i + 1));
// bt[i] = sc.nextInt();
// }
// SJF(at, bt, no_of_processes);
// sc.close();
// }

// private static void SJF(int[] at, int[] bt, int n) {
// int ct[] = new int[n];
// int tat[] = new int[n];
// int wt[] = new int[n];
// int fg[] = new int[n]; // flags for checking if process is completed or not
// int total = 0;
// int st = 0;

// while (true) {
// int minBurstTime = Integer.MAX_VALUE;
// int shortestProcess = -1;

// if (total == n) {
// break;
// }

// for (int i = 0; i < n; i++) { /// this loop is for to calculate the process
// which arrives first with
// /// shortest brust time
// if (at[i] <= st && fg[i] == 0 && bt[i] < minBurstTime) {
// minBurstTime = bt[i];
// shortestProcess = i;
// }
// }

// if (shortestProcess == -1) {
// st++;
// } else {
// ct[shortestProcess] = st + bt[shortestProcess];
// tat[shortestProcess] = ct[shortestProcess] - at[shortestProcess];
// wt[shortestProcess] = tat[shortestProcess] - bt[shortestProcess];
// fg[shortestProcess] = 1;
// st = ct[shortestProcess];
// total++;
// }
// }

// System.out.println("Solution: \n\n");
// System.out.println("P#\t AT\t BT\t CT\t TAT\t WT\t\n\n");

// for (int k = 0; k < n; k++) {
// System.out.println((k + 1) + "\t" + at[k] + "\t" + bt[k] + "\t" + ct[k] +
// "\t" + tat[k] + "\t" + wt[k]);
// }
// }

// }

// for testing
// n=5
// at=[1,3,6,7,9]
// bt=[7,3,2,10,8]