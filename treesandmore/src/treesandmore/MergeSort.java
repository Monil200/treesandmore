package treesandmore;

import java.util.Arrays;

public class MergeSort {
    public static int a[] = {3 ,6 ,1, 2, 99, 123,21};
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int limit = a.length/2;
        int size = 2;
        while(size<=limit) {
            createPartitionsOfSize(a, size);
            size++;
        }
        System.out.println("Result: "  + Arrays.toString(a));
    }
    
    public static void createPartitionsOfSize(int a[], int size) {
        int index = 0;
        int putIndex = 0;
        int counter = 0;
        int start;
        while(index < a.length) {
            start = index;
            int a1[] = new int[size];
            int a2[] = new int[size];
            for(int i=0;i<a1.length;i++) {
                a1[i] = -1;
                a2[i] = -1;
            }
            counter = 0;
            putIndex = 0;
            while(counter < size && index < a.length) {
                a1[putIndex] = a[index];
                index++;
                putIndex++;
                counter++;
            }
            counter = 0;
            putIndex = 0;
            try {
                while(counter < size && index < a.length) {
                    a2[putIndex] = a[index];
                    index++;
                    putIndex++;
                    counter++;
                }
            } catch(Exception e) {}
            System.out.print(Arrays.toString(a1));
            System.out.println(" "  + Arrays.toString(a2));
            merge2piecesIntoMain(a1,a2, start);
        }
    }
    
    
    public static void merge2piecesIntoMain(int a1[], int a2[], int start) {
        int index1 = 0;
        int index2 = 0;
        int counter = start;
        while(index1< a1.length && index2 < a2.length) {
            if (a1[index1] == -1 || a2[index2] == -1) {
                break;
            }
            if (a1[index1] <= a2[index2]) {
                a[counter] = a1[index1];
                index1++;
            } else {
                a[counter] = a2[index2];
                index2++;
            }
            counter++;
        }
        while (index1<a1.length && a1[index1] != -1) {
            a[counter] =a1[index1];
            index1++;
            counter++;
        }
        while (index2<a2.length && a2[index2] != -1) {
            a[counter] =a2[index2];
            index2++;
            counter++;
        }
        System.out.println("Intermediate Result: "  + Arrays.toString(a));
     }
}
