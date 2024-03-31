import java.util.Arrays;
import java.util.Random;

public class quicksort {


    public static void main(String[] args){
        int numbers[] = new int[1000000];
        int numbers_2[] = numbers; 
        Random random = new Random();

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = random.nextInt(100000);
        }
        System.out.println(Arrays.toString(numbers));
        long startTime = System.currentTimeMillis();

        quicksort_base(numbers, 0, numbers.length -1);

        long endTime = System.currentTimeMillis();        
        System.out.println(Arrays.toString(numbers));
        System.out.println("Base quicksort took about " + (endTime - startTime) + "ms");


        long startTime2 = System.currentTimeMillis();

        quicksort_median(numbers_2, 0, numbers.length -1);

        long endTime2 = System.currentTimeMillis();        
        System.out.println(Arrays.toString(numbers));
        System.out.println("Median of three quicksort took about " + (endTime2 - startTime2) + "ms");
    }

    private static void quicksort_base(int[] numbers, int lowIndex, int highIndex) {

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

        quicksort_base(numbers, lowIndex, leftPointer - 1);
        quicksort_base(numbers, leftPointer + 1, highIndex);
    }



        private static void quicksort_median(int[] numbers, int lowIndex, int highIndex) {

        if(lowIndex >= highIndex){
            return;
        }

        int middle = lowIndex + (highIndex - lowIndex) / 2;
        int pivot = numbers[middle];

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

        quicksort_median(numbers, lowIndex, leftPointer - 1);
        quicksort_median(numbers, leftPointer + 1, highIndex);
    }


    private static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }


    
}
