package Sorting;
public class InsertionSort {

    // Quadratic complexity sorting
    void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i <= n - 1; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
                }
            arr[j + 1] = key;
        }
    }
 
    // A utility function to print array of size n
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
 
        System.out.println("Given array is");
        printArray(arr);
 
        InsertionSort ob = new InsertionSort();
        ob.sort(arr);
 
        System.out.println("\nSorted array is");
        printArray(arr);
    }
}