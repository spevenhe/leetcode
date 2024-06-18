package practice.medium;

public class testmain {

    public static void main(String[] args) {
        quickSort qs = new quickSort();
        int[] arr = {5, 2, 9, 4, 7, 6, 1, 3, 8};
        qs.quickSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
