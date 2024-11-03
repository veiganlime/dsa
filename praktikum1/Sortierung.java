package praktikum1;

public class Sortierung {

    private static int partition(int[] a, int begin, int end) {

        int pivot = a[end];
        int i = begin - 1;
        
        for (int j = begin; j < end; j++) {
            if (a[j] >= pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i + 1];
        a[i + 1] = a[end];
        a[end] = temp;
        return i + 1;
    }


    public static void sortiere(int[] a, int begin, int end) {

        if (begin < end) {

            int pivotIndex = partition(a, begin, end);
            sortiere(a, begin, pivotIndex - 1);
            sortiere(a, pivotIndex + 1, end);
        }
    }


    public static void main(String[] args) {

        int[] a = {99, 0, 33, 27, 87, 80, 65, 77, 39, 88};        
        System.out.println("Zu sortierendes Array:");

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }

        System.out.println("");
        sortiere(a, 0, a.length - 1);
        System.out.println("Sortiertes Array:");


        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
}
