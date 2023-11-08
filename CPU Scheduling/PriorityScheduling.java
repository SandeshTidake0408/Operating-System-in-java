import java.util.Scanner;

public class PriorityScheduling {

    public static void main(String[] args) {
        int no_of_processes;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of Processes : ");
        no_of_processes = sc.nextInt();
        System.out.println("Enter Arival time and burst time for each process\n");
        int bt[] = new int[no_of_processes];
        int at[] = new int[no_of_processes];
        int pt[] = new int[no_of_processes];

        for (int i = 0; i < no_of_processes; i++) {
            System.out.println("Enter the Priority of process " + (i + 1));
            pt[i] = sc.nextInt();
            System.out.println("Enter the Arrival time of process " + (i + 1));
            at[i] = sc.nextInt();
            System.out.println("Enter the Brust time of process " + (i + 1));
            bt[i] = sc.nextInt();
        }
        Priority(at, bt, pt, no_of_processes);
        sc.close();
    }

    private static void Priority(int[] at, int[] bt, int[] pt, int n) {
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        int fg[] = new int[n];

        int total = 0;
        int st = 0;

        while (total < n) {
            int max_priority = Integer.MAX_VALUE;
            int high_p_process = -1;

            for (int i = 0; i < n; i++) { // this loop is for to calculate the process which arrives first with
                                          /// shortest brust time
                if (at[i] <= st && fg[i] == 0 && pt[i] < max_priority) {
                    max_priority = pt[i];
                    high_p_process = i;
                }
            }

            if (high_p_process == -1) {
                st++;
            } else {
                ct[high_p_process] = st + bt[high_p_process];
                tat[high_p_process] = ct[high_p_process] - at[high_p_process];
                wt[high_p_process] = tat[high_p_process] - bt[high_p_process];
                fg[high_p_process] = 1;
                st = ct[high_p_process];
                total++;
            }
        }
        System.out.println("Solution: \n\n");
        System.out.println("P#\t PT\t AT\t BT\t CT\t TAT\t WT\t\n\n");

        for (int k = 0; k < n; k++) {
            System.out.println((k + 1) + "\t" + pt[k] + "\t" + at[k] + "\t" + bt[k] + "\t" + ct[k] + "\t" + tat[k]
                    + "\t" + wt[k]);
        }
    }
}

// P# PT AT BT CT TAT WT

// 1 2 0 3 3 3 0
// 2 6 2 5 18 16 11
// 3 3 1 4 7 6 2
// 4 5 4 2 13 9 7
// 5 7 5 9 27 22 13
// 6 4 5 4 11 6 2
// 7 10 7 10 37 30 20