import java.util.*;

class process {
    String name;
    int burstTime;
    int ramainingTime;

    process(String name, int brst) {
        this.name = name;
        this.burstTime = brst;
        this.ramainingTime = brst;
    }
}

class helper {

    Scanner sc = new Scanner(System.in);

    void getInputs(Queue<process> q, process[] proce, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the process name");
            String name = sc.next();

            System.out.println("Enter the burst time");
            int brst = sc.nextInt();

            proce[i] = new process(name, brst);
            q.add(proce[i]);

        }
    }

    void execute(Queue<process> q, process[] proce, int quantum) {
        int currentTime = 0;
        int totalWaitTime = 0;
        int totalTurnAroundtime = 0;

        while (!q.isEmpty()) {
            process currentProcess = q.poll();
            // System.out.println();
            if (currentProcess.ramainingTime > quantum) {
                currentProcess.ramainingTime -= quantum;
                currentTime += quantum;
                q.add(currentProcess);
            } else {
                currentTime += currentProcess.ramainingTime;
                totalTurnAroundtime += currentTime;
                totalWaitTime += currentTime - currentProcess.burstTime;
                currentProcess.ramainingTime = 0;
            }
        }

        int numProcesses = proce.length;
        int avgWaitTime = totalWaitTime / numProcesses;
        int avgTurnaroundTime = totalTurnAroundtime / numProcesses;

        System.out.println("Average Waiting Time: " + avgWaitTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);

    }

}

public class RoundRobinScheduling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter how many process you want");
        int n = sc.nextInt();

        process[] proce = new process[n];
        helper h1 = new helper();
        Queue<process> q = new LinkedList<>();

        h1.getInputs(q, proce, n);

        h1.execute(q, proce, 2);
        sc.close();

    }

}
// import java.util.*;

// public class RoundRobinScheduling {

// public static void main(String[] args) {
// int no_of_processes, q;
// Scanner sc = new Scanner(System.in);
// System.out.println("Enter the no of Processes : ");
// no_of_processes = sc.nextInt();
// System.out.println("Enter the time Qauntum for processes : ");
// q = sc.nextInt();
// System.out.println("Enter Arival time and burst time for each process\n");
// int bt[] = new int[no_of_processes];
// int at[] = new int[no_of_processes];

// for (int i = 0; i < no_of_processes; i++) {
// System.out.println("Enter the Arrival time of process " + (i + 1));
// at[i] = sc.nextInt();
// System.out.println("Enter the Brust time of process " + (i + 1));
// bt[i] = sc.nextInt();
// }
// RR(at, bt, no_of_processes, q);
// sc.close();
// }

// private static void RR(int[] at, int[] bt, int n, int quantum) {
// int ct[] = new int[n];
// int tat[] = new int[n];
// int wt[] = new int[n];
// int fg[] = new int[n]; // flags for checking if the process is completed
// ornot
// int st = 0;
// int remainingBurst[] = new int[n];

// for (int i = 0; i < n; i++) {
// remainingBurst[i] = bt[i];
// }

// while (true) {
// boolean done = true;
// for (int i = 0; i < n; i++) {
// if (at[i] <= st && fg[i] == 0) {
// if (remainingBurst[i] > quantum) {
// st += quantum;
// remainingBurst[i] -= quantum;

// } else {
// st += remainingBurst[i];
// remainingBurst[i] = 0;
// ct[i] = st;
// tat[i] = ct[i] - at[i];
// wt[i] = tat[i] - bt[i];
// fg[i] = 1;
// }
// done = false;
// }
// }
// if (done)
// break;
// }
// System.out.println("Solution: \n\n");
// System.out.println("P#\t AT\t BT\t CT\t TAT\t WT\t\n\n");

// for (int k = 0; k < n; k++) {
// System.out.println((k + 1) + "\t" + at[k] + "\t" + bt[k] + "\t" + ct[k] +
// "\t" + tat[k] + "\t" + wt[k]);
// }
// }

// }
