import java.util.Arrays;
import java.util.Random;

public class bubblesort {
    public static void main(String[] args){
        int numbers[] = new int[10];
        Random random = new Random();

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(numbers));
        long startTime = System.currentTimeMillis();

        bubbleSort(numbers);
        
        long endTime = System.currentTimeMillis();        
        System.out.println(Arrays.toString(numbers));
        System.out.println("Took " + (endTime - startTime) + "ms");
    }
// first variant
    // private static void bubbleSort(int[] numbers) {

    //     boolean swapped = true;
    //     while (swapped){

    //         for (int i = 0; i < numbers.length - 1; i++){
    //             swapped = false;
    //             if (numbers[i] > numbers[i + 1]){
    //                 swapped = true;
    //                 int temp = numbers[i];
    //                 numbers[i] = numbers[i + 1];
    //                 numbers[i + 1] = temp;
    //             }
    //         }
    //     }
    // }

// second variat 
    private static void bubbleSort(int[] numbers) {

        for(int i = 0; i < numbers.length - 1; i++){

            for(int j = 0; j < numbers.length - i - 1; j++){

                if (numbers[j] >= numbers[j + 1]){
                    
                    swap(numbers, j, j + 1);

                }
            }
        }
    }

    private static void swap(int[] numbers, int index1, int index2) {

        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }
}
