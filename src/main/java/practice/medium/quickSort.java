package practice.medium;

import java.util.Random;

public class quickSort {
    Random rad = new Random();

    public void quickSort(int[] array){
        int left = 0;
        int right = array.length-1;
        int partition = partition(array,left,right);
        quickSort(array,left,partition);
        quickSort(array,partition+1,right);
    }

    public void quickSort(int[] array, int left, int right){
        if(left >= right){
            return;
        }
        int partition = partition(array,left,right);
        quickSort(array,left,partition-1);
        quickSort(array,partition+1,right);
    }

    private void swap(int[] array, int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }


    public int partition(int[] array, int left, int right){
        int randomIndex = rad.nextInt(right - left + 1) + left;
        swap(array, left, randomIndex);

        int pivot = array[left];
        int i = left;
        int j = right;
        while(i <j){
            while(i < j && array[j] > pivot){
                j--;
            }
            while(i < j && array[i] <= pivot){
                i++;
            }
            if(i!=j){
                swap(array,i,j);
            }

        }
        if(i!= left){
            swap(array,left,i);
        }
        return i;
    }
}
