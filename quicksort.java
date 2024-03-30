import java.util.Arrays;
import java.util.Random;

public class quicksort {


    public static void main(String[] args){
        int numbers[] = new int[10];
        Random random = new Random();

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(numbers));
        long startTime = System.currentTimeMillis();

        quicksort(numbers, 0, numbers.length -1);

        long endTime = System.currentTimeMillis();        
        System.out.println(Arrays.toString(numbers));
        System.out.println("Took " + (endTime - startTime) + "ms");
    }

    private static void quicksort(int[] numbers, int lowIndex, int highIndex) {

        if(lowIndex >= highIndex){
            return;
        }

        int pivot = numbers[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer){

            while (numbers[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (numbers[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(numbers, leftPointer, rightPointer);
        }
        swap(numbers, leftPointer, highIndex);

        quicksort(numbers, lowIndex, leftPointer - 1);
        quicksort(numbers, leftPointer + 1, highIndex);
    }

    private static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }


    
}
