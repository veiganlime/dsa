package praktikum1;

public class QuickSort {
    public static void quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int pivotIndex = partition(array, begin, end);
            quickSort(array, begin, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (array[j] >= pivot) { // Bedingung für absteigende Reihenfolge
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {99, 0, 33, 27, 87, 80, 65, 77, 39, 88};
        System.out.println("Unsortiertes Array:");
        for (int num : array) System.out.print(num + " ");
        System.out.println();

        quickSort(array, 0, array.length - 1);

        System.out.println("Absteigend sortiertes Array:");
        for (int num : array) System.out.print(num + " ");
    }
}
