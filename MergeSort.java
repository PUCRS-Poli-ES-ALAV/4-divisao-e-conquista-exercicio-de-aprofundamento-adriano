/*
    Projeto & Otimização de Algoritmos 2022/1   
    Adriano Leal
*/

// Complexity: O(nlogn)
public class MergeSort {

    static int count = 0;

    // Exercício preparatório para Divisão & Conquista
    public static void main(String args[]) {

    }

    public void mergeSort(int[] a, int n) {
        
        if(n < 2) {
            return;
        }

        int mid = n/2;
        int[] left = new int [mid];
        int[] right = new int [n - mid];

        for(int i=0; i<mid; i++) {
            left[i] = a[i];
        }

        for(int i = mid; i < n; i++) {
            right[i - mid] = a[i];
        }

        mergeSort(left, mid);
        mergeSort(right, n-mid);
        merge(a, left, right, mid, n-mid);

        count++;

    }

    private int maxVal1(int A[], int n) {
        int max = A[0];

        for(int i=0; i<n; i++) {
            if(A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    private int maxVal2(int A[], int init, int end) {
        if(end-init <= 1) {
            return Math.max(A[init], A[end]);
        } else {
            int m = (init + end)/2;
            int v1 = maxVal2(A, init, m);
            int v2 = maxVal2(A, m+1, end);
            return Math.max(v1, v2);
        }
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right){
        int i = 0, j = 0, k = 0;
        while(i < left && j < right){
            if(l[i] <= r[j]){
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while(i < left){
            a[k++] = l[i++];
        }
        while(j < right){
            a[k++] = r[j++];
        }
    }

}