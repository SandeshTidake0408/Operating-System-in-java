
import java.util.*;

public class RoundRobinScheduling {

    public static void main(String[] args) {
        int no_of_processes, q;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of Processes : ");
        no_of_processes = sc.nextInt();
        System.out.println("Enter the time Qauntum for processes : ");
        q = sc.nextInt();
        System.out.println("Enter Arival time and burst time for each process\n");
        int bt[] = new int[no_of_processes];
        int at[] = new int[no_of_processes];

        for (int i = 0; i < no_of_processes; i++) {
            System.out.println("Enter the Arrival time of process " + (i + 1));
            at[i] = sc.nextInt();
            System.out.println("Enter the Brust time of process " + (i + 1));
            bt[i] = sc.nextInt();
        }
        RR(at, bt, no_of_processes, q);
        sc.close();
    }

    private static void RR(int[] at, int[] bt, int n, int quantum) {
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        int fg[] = new int[n]; // flags for checking if the process is completed ornot
        int st = 0;
        int remainingBurst[] = new int[n];

        for (int i = 0; i < n; i++) {
            remainingBurst[i] = bt[i];
        }

        while (true) {
            boolean done = true;
            for (int i = 0; i < n; i++) {
                if (at[i] <= st && fg[i] == 0) {
                    if (remainingBurst[i] > quantum) {
                        st += quantum;
                        remainingBurst[i] -= quantum;

                    } else {
                        st += remainingBurst[i];
                        remainingBurst[i] = 0;
                        ct[i] = st;
                        tat[i] = ct[i] - at[i];
                        wt[i] = tat[i] - bt[i];
                        fg[i] = 1;
                    }
                    done = false;
                }
            }
            if (done)
                break;
        }
        System.out.println("Solution: \n\n");
        System.out.println("P#\t AT\t BT\t CT\t TAT\t WT\t\n\n");

        for (int k = 0; k < n; k++) {
            System.out.println((k + 1) + "\t" + at[k] + "\t" + bt[k] + "\t" + ct[k] +
                    "\t" + tat[k] + "\t" + wt[k]);
        }
    }

}
