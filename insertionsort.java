import java.util.Arrays;
import java.util.Random;

public class insertionsort {
    public static void main(String[] args){
        int numbers[] = new int[10];
        Random random = new Random();

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(numbers));
        long startTime = System.currentTimeMillis();

        insertionSort(numbers);
        
        long endTime = System.currentTimeMillis();        
        System.out.println(Arrays.toString(numbers));
        System.out.println("Took " + (endTime - startTime) + "ms");
    }

    private static void insertionSort(int[] numbers) {

        for(int i = 1; i < numbers.length; i++){

            int temp = numbers[i];
            int tempIndex  = i - 1;

            while (tempIndex > -1  && numbers[tempIndex] > temp) {

                numbers[tempIndex + 1] = numbers[tempIndex];
                tempIndex--; 
            }

            numbers[tempIndex + 1] = temp;

        }
    }
}
