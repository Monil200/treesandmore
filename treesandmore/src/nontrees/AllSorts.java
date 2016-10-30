package nontrees;

public class AllSorts {
    public void bubbleSort(int a[]) {
        int temp;
        int i = a.length-1;
        while(i>=0) {
            for (int j=0; j<i;j++) {
                if(a[j] > a[j+1]) {
                    temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
            --i;
        }
        for (int j=0; j<a.length;j++) {
            System.out.println(a[j] + " , ");
        }
    }
    
    public void quickSort(int a[], int start, int end) {
        
        if(start < end) {
            int p = partition(a, start , end);
            System.out.print(p+ "p \n");
            for(int k=0;k<a.length;k++)
                System.out.print(a[k]+" ");
            System.out.println();
            quickSort(a, start, p);
            quickSort(a, p+1, end);
        }
    }
    
    public int partition(int a[], int start, int end) {
        int pivot = a[start];
        int i = start;
        int j = end;
        while(true) {
            while (a[start] < pivot && start < j) {
                start++;
            }
            while (a[end] > pivot && end > i) {
                end--;
            }
            if (start < end) {
                swap(a, start, end);
            } else {
                return end;
            }
            
        }
    }
    
    private static void swap(int[] a, int i, int j) {
        // TODO Auto-generated method stub
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {3 ,6 ,1, 2, 99, 123, 21};
        AllSorts obj = new AllSorts();
//        obj.bubbleSort(a);
        obj.quickSort(a, 0, a.length-1);
    }

}
