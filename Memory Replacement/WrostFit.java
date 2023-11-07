import java.util.*;

public class WrostFit {
    public static void performWorstFit(int[] mem, int[] proce, int m, int n) {
        int[] allocate = new int[n];
        Arrays.fill(allocate, -1);

        for (int i = 0; i < n; i++) {
            int worstIndex = -1;
            for (int j = 0; j < m; j++) {
                if (mem[j] >= proce[i]) {
                    if (worstIndex == -1 || mem[worstIndex] < mem[j]) {
                        worstIndex = j;
                    }
                }
            }

            if (worstIndex != -1) {
                allocate[i] = worstIndex;
                mem[worstIndex] -= proce[i];
                
            }
        }

        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < n; i++) {
            System.out.print("   " + (i + 1) + "\t\t" + proce[i] + "\t\t");
            if (allocate[i] != -1)
                System.out.print(allocate[i] + 1);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int blockSize[] = { 100, 500, 200, 300, 600 };
        int processSize[] = { 212, 417, 112, 426 };
        int m = blockSize.length;
        int n = processSize.length;
        performWorstFit(blockSize, processSize, m, n);

    }
}