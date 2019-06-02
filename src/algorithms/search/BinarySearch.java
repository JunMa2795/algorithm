package algorithms.search;

/**
 * Created by jack.
 * Date: 2019-06-01
 * Time: 17:05
 */
public class BinarySearch {

    public static int binarySearchIteratively(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if(key < arr[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    public static int binarySearchRecursively(int[] arr, int lo, int hi, int key) {
        if (lo > hi) {
            return -1;
        }

        int mid = (lo + hi) / 2;

        if (key == arr[mid]) {
            return mid;
        } else if (key > arr[mid]) {
            return binarySearchRecursively(arr, mid + 1, hi, key);
        } else {
            return binarySearchRecursively(arr, lo, mid - 1, key);
        }
    }
}
