import java.util.Scanner;
import java.util.Random;

public class SimpleSorting {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int[] afterArray = new int[10];
        int[] beforeArray = new int[10];
        int choice = 0;



        while(choice!=4){
            // populating arrays
            for(int i = 0; i<10; i++){
                afterArray[i] = r.nextInt(100);
            }
            System.arraycopy(afterArray, 0, beforeArray, 0, 10);
            System.out.println("\nHere is your new array: ");
            printArray(beforeArray);
            System.out.print("\nChoose a sorting algorithm:\n1 - Bubble Sort\n2 - Insertion sort\n3 - Selection Sort\n4 - Exit\n\nEnter Choice: ");
            choice=Integer.parseInt(sc.nextLine());

            //Bubble Sort
            if(choice == 1){
                System.out.print("\nHere is the bubble sort process. We will be going from right to left sorting in ascending order.\nInitial array: ");
                printArray(beforeArray);
                bubbleSort(afterArray);
                System.out.print("\nArray before sorting: ");
                printArray(beforeArray);
                System.out.print("Array after sorting:  ");
                printArray(afterArray);
            }

            //Insertion Sort
            else if(choice == 2){
                System.out.print("\nHere is the Insertion sort process.\nInitial array: ");
                printArray(beforeArray);
                insertionSort(afterArray);
                System.out.print("\nArray before sorting: ");
                printArray(beforeArray);
                System.out.print("Array after sorting:  ");
                printArray(afterArray);
            }

            //Selection Sort
            else if(choice == 3){
                System.out.print("\nHere is the selection sort process.\nInitial array: ");
                printArray(beforeArray);
                selectionSort(afterArray);
                System.out.print("\nArray before sorting: ");
                printArray(beforeArray);
                System.out.print("Array after sorting:  ");
                printArray(afterArray);
            }

            else if(choice < 0 || choice > 4){System.out.println("Invalid choice.\n");}
        }
    }

    /*
    * BUBBLE SORT PSEUDO CODE:
    *  n = array length - 1
    * For i = 0 to n (Ascending order)
    *    For j = n downto i
    *       Compare A[j] and A[j-1]
    *       Swap if needed
    *    End Loop
    * End Loop
    * */
    public static void bubbleSort(int[] A){
        boolean swapped;

        int count=0;
        int n = A.length-1;
        for(int i = 0; i<n; i++){
            swapped = false;
            for(int j = n; j > i; j--){
                if(A[j] > A[j-1]) {
                    count++;
                    System.out.println("\nComparison "+count+":\nComparing "+A[j]+" to "+A[j-1]+"\n"+A[j]+" is greater than "+A[j-1]+". Swapping.");
                    //bubble sort
                    int temp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = temp;
                    //
                    printArray(A);
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
        }
    }

    /*
    Selection Sort Pseudo Code
    * For i = 0 to n-1
       minimum value  = i
    *   For j = i+1 to n
    *      IF (A[j] < A[minimum value])
    *       swap(A[j],A[minimum value])
            minimum value = j
    *   End Loop
    * End Loop
    * */
    public static void selectionSort(int[] A){
        int n = A.length;
        int count = 0;
        for(int i = 0; i < n-1; i++){
            int min_idx = i;
            for(int j = i+1; j < n; j++){
                if(A[j] < A[min_idx]){
                    //System.out.println("\nComparison "+count+":\nComparing "+A[j]+" to "+A[i]+"\n"+A[j]+" is less than "+A[i]+". Swapping.");
                    min_idx = j;
                }
            }
            if (min_idx != i){
                count++;
                System.out.println();
                printArray(A);
                System.out.println("Comparison "+count+":\nSmallest value found is: "+A[min_idx]);
                System.out.println("Swapping "+A[i]+" with "+A[min_idx]);
                int temp = A[i];
                A[i] = A[min_idx];
                A[min_idx] = temp;
            }
        }
    }

    /*INSERTION SORT PSEUDO CODE
    * For i = 1 to n
    *   key = A[i]
    *
    *    For k = i - 1 to 1
    *      IF (A[k] > A[k+1}
    *         swap (A[k], A[k+1]
    *      ELSE
    *         exit loop
    *     End Loop
    *End Loop
    *
    *
    * */
    public static void insertionSort(int[] A){
        int n = A.length;
        for(int i = 1; i < n ; i++){
            int key = A[i];
            int j = i - 1;
            System.out.println("\nKey: "+key);
            while( j >= 0 && A[j] > key){
                printArray(A);
                System.out.println("Swapping "+A[j+1]+" with "+A[j]);
                A[j+1] = A[j];
                j = j-1;
                printArray(A);
            }
            A[j+1] = key;
        }
    }

    public static void printArray(int[] x){
        for(int i = 0; i < x.length; i++){
            System.out.print(x[i]+" ");
        }
        System.out.println();
    }
}
