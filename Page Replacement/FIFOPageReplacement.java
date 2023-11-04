import java.util.*;

// fifo using queue
public class FIFOPageReplacement {
    public static int pageReplacement(int arr[], int frameSize) {
        int fault = 0;
        int hit = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (q.size() < frameSize) {
                q.add(arr[i]);
                fault++;
            } else {
                if (q.contains(arr[i])) {
                    hit = hit + 1;
                } else {
                    q.remove();
                    fault++;
                    q.add(arr[i]);
                }
            }
        }
        System.out.println("Count Of Hits : " + hit);
        return fault;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 1, 2, 0 };
        int capacity = 3;
        System.out.println();
        System.out.println("Count Of Page Fault : " + pageReplacement(arr, capacity));
    }
}
