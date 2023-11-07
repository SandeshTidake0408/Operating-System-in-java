
import java.util.*;

public class Next {

    public static void NextFit(int[] mem, int[] proce, int m, int n) {
        int[] allocate = new int[n];
        Arrays.fill(allocate, -1);
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < m) {
                if (mem[j] >= proce[i]) {
                    allocate[i] = j;
                    mem[j] -= proce[i];
                    break;
                }
                j = (j + 1) % m;
            }
        }
        for (int k = 0; k < n; k++) {
            System.out.println("process-> " + proce[k] + "-----> " + (allocate[k]+1));
        }
    }

    public static void main(String[] args) {

        int[] mem = { 5, 10, 20 };
        int[] process = { 10, 20, 5 };
        int m = mem.length;
        int n = process.length;
        NextFit(mem, process, m, n);
    }
}