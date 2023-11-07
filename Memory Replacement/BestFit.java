import java.util.*;

public class BestFit {
    public static void performBestFit(int[] mem, int[] proce, int m, int n) {
        int[] allocate = new int[n];
        Arrays.fill(allocate, -1);
        for (int i = 0; i < n; i++) {
            int bestIndex = -1;
            for (int j = 0; j < m; j++) {
                if (mem[j] >= proce[i]) {
                    if (bestIndex == -1 || mem[bestIndex] > mem[j]) {
                        bestIndex = j;
                    }
                    // else if (mem[bestIndex]>=mem[j]){
                    // bestIndex=j;
                    // }
                }
            }

            if (bestIndex != -1) {
                allocate[i] = bestIndex;
                mem[bestIndex] -= proce[i];
            }
        }
        System.out.println("Process No.\tProcess Size\tBlock No.");
        for (int i = 0; i < n; i++) {
            System.out.println(
                    i + 1 + "\t\t" + proce[i] + "\t\t" + (allocate[i] != -1 ? allocate[i] + 1 : "Not Allocated"));
        }

    }

    public static void main(String[] args) {
        int[] blocksize = { 100, 500, 200, 300, 600 };
        int[] processsize = { 212, 417, 112, 426 };
        int m = blocksize.length;
        int n = processsize.length;
        
        performBestFit(blocksize, processsize, m, n);

    }

}