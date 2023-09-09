package module;

public class Algorithm {
    public void buddleSort(int[] array) {

        int size = array.length;
        // Loop use to accessed from the first to last element of array
        for (int i = 0; i < size; i++) {
            /*Loop use to accessed first unsorted element to the element
            stand before the last unsorted element*/
            for (int j = 0; j < size - (i + 1); j++) {
                /* compare each pair adjacent elements
                if reversed order then swap order
                */
                if (array[j] > array[j + 1]) {
                    // use temp variable store value of first element
                    int temp = array[j];
                    // assign value of second element for first element
                    array[j] = array[j + 1];
                    // assign value of temp element for second element
                    array[j + 1] = temp;
                }
            }
        }
    }




    public void quickSort(int[] array, int l, int h)  {
        if (l < h) {
            // Find pivot element such that elements smaller than pivot are on the left and elements greater than pivot are on the right
            int p = partition(array, l, h);

            // Recursively sort elements before and after the partition
            quickSort(array, l, p - 1);
            quickSort(array, p + 1, h);
        }
    }


    public int partition(int[] a, int l, int h)  {
        // Select the pivot element (usually the first element in the subarray).
        int p = a[l];


        int m = l;


        for (int k = l + 1; k <= h; k++) {
            if (a[k] < p) {
                m++;
                swap(a, k, m); // Swap elements less than pivot
            }
        }

        swap(a, l, m); // Place pivot in the correct position
        return m; // Return pivot index
    }

    // Swaps two elements in an array.
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int linearSearch(int[] array, int value, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (array[i] == value) {

                return i; // Return the index where the value was found
            }
        }

        System.out.println("Element not found in the specified range.");
        return -1; // Return -1 if the value is not found in the specified range
    }


    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // target not found
    }
}
