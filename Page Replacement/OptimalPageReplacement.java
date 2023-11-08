import java.util.*;

public class OptimalPageReplacement {
    private static int search(int[] a, Queue<Integer> memory, int currentIndex) {
        int farthestDistance = currentIndex;
        int pageToReplace = -1;

        for (int page : memory) {
            int nextIndex = -1;
            for (int i = currentIndex + 1; i < a.length; i++) {
                if (a[i] == page) {
                    nextIndex = i;
                    break;
                }
            }

            if (nextIndex == -1) {
                return page; // If a page won't be referenced again, replace it.
            } else if (nextIndex > farthestDistance) {
                farthestDistance = nextIndex;
                pageToReplace = page;
            }
        }

        return pageToReplace;
    }

    private static void optimalPage(int[] arr, int frameSize) {
        int fault = 0;
        int hit = 0;

        Queue<Integer> memory = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (memory.size() < frameSize) {
                memory.add(arr[i]);
                fault = fault + 1;
            } else {
                if (memory.contains(arr[i])) {
                    hit = hit + 1;
                } else {
                    memory.remove(search(arr, memory, i));
                    fault++;
                    memory.add(arr[i]);
                }
            }
        }
        System.out.println("fault: " + fault + " " + "hit: " + hit);
    }

    public static void main(String[] args) {
        // int pgs[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1 };
        // int pgs[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3 };
        int pgs[] = { 1, 2, 3, 4, 1, 2, 5, 1, 6, 2, 3, 7, 8, 7, 8, 9, 7, 8, 9, 5 };
        int frameSize = 3;
        optimalPage(pgs, frameSize);
    }
}