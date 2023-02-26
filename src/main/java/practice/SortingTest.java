package practice;

import java.util.Arrays;

public class SortingTest {
    public int[] solution(int[] arr) {
        //冒泡排序
//        if (arr == null || arr.length < 2) return arr;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int tmp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = tmp;
//                }
//            }
//        }
//        return arr;

        //选择排序
//        if (arr == null || arr.length < 2) return arr;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[i]) {
//                    swap(arr, j, i);
//                }
//            }
//        }
//        return arr;

        //插入排序
//        if (arr == null || arr.length < 2) return arr;
//        for (int i = 1; i < arr.length; i++) {
//            int low = 0;
//            int high = i - 1;
//            int tmp = arr[i];
//
//            while (low <= high) {
//                int mid = low + (high - low) / 2;
//                if (arr[mid] < tmp) {
//                    low = mid + 1;
//                } else {
//                    high = mid - 1;
//                }
//            }
//
//            for (int j = i - 1; j >= high + 1; j--) {
//                arr[j + 1] = arr[j];
//            }
//            arr[high + 1] = tmp;
//        }
//        return arr;

        //快速排序
//        quickSort(arr, 0, arr.length - 1);
//        return arr;

        //归并排序
        if (arr == null || arr.length < 2) return arr;
        return mergeSort(arr);
    }

    private int[] mergeSort(int[] arr) {
        if (arr.length < 2) return arr;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }


    private int[] merge(int[] left, int[] right) {
        int lengthLeft = left.length;
        int lengthRight = right.length;
        int[] res = new int[lengthRight + lengthLeft];
        int i = 0;
        int j = 0;
        int z = 0;
        while (i < lengthLeft && j < lengthRight) {
            if (left[i] < right[j]) {
                res[z] = left[i];
                i++;
                z++;
            } else {
                res[z] = right[j];
                j++;
                z++;
            }
        }
        while (j < lengthRight) {
            res[z] = right[j];
            j++;
            z++;
        }
        while (i < lengthLeft) {
            res[z] = left[i];
            i++;
            z++;
        }
        return res;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int i = left;
        int j = right;
        int pivot = arr[left];
        while (i < j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i < j) swap(arr, i, j);
        }
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        SortingTest test = new SortingTest();
        int[] arr = new int[] {2,5,1,10,8};
        int[] res = test.solution(arr);
        System.out.println(Arrays.toString(res));
    }
}
