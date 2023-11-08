import java.util.*;

public class LeastRecentlyUsed {
    public static int recentlyUsed(int arr[], int frameSize) {
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
                    q.remove(predict(arr, i, q));
                    fault++;
                    q.add(arr[i]);
                }
            }
        }
        System.out.println("fault: " + fault + " " + "hit: " + hit);
        return fault;
    }

    private static int predict(int[] a, int i, Queue<Integer> memory) {
        int oldElement = -1;
        int farthestDistance = i;
        for (Integer page : memory) {
            int nextIndex = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (page == a[j]) {
                    nextIndex = j;
                    break;
                }
            }
            if (nextIndex == -1) {
                return page;
            } else if (nextIndex < farthestDistance) {
                farthestDistance = nextIndex;
                oldElement = page;
            }
        }
        return oldElement;
    }

    public static void main(String[] args) {
        // int pgs[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1 };
        
        int pgs[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        int frameSize = 3;
        recentlyUsed(pgs, frameSize);
    }
}
