
import java.util.*;

public class FirstFit {
    public static void firstFit(int[] mem, int[] proce, int m, int n) {
        int[] allocated = new int[n];
        Arrays.fill(allocated, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mem[j] >= proce[i]) {
                    allocated[i] = j;
                    mem[j] -= proce[i];
                    break;
                }
            }
        }

        System.out.println("after process");
        for (int k = 0; k < n; k++) {
            if (allocated[k] != -1) {
                System.out.println("process " + proce[k] + "-> " + (allocated[k] + 1));
            } else {
                System.out.println("process " + proce[k] + "-> " + "Unallocated");
            }
        }
    }

    public static void main(String[] args) {
        int blockSize[] = { 100, 500, 200, 300, 600 };
        int processSize[] = { 212, 417, 112, 426 };
        int m = blockSize.length;
        int n = processSize.length;
        firstFit(blockSize, processSize, m, n);
    }
}