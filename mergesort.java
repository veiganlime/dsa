import java.util.Arrays;
import java.util.Random;

public class mergesort {
    public static void main(String[] args){
        int numbers[] = new int[10];
        Random random = new Random();

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(numbers));
        long startTime = System.currentTimeMillis();

        mergeSort(numbers);
        
        long endTime = System.currentTimeMillis();        
        System.out.println(Arrays.toString(numbers));
        System.out.println("Took " + (endTime - startTime) + "ms");
    }
// Split the array into a two part and first check if the array has more then 2 element
    private static void mergeSort(int[] numbers) {
        if (numbers.length < 2){
            return;
        }

        int midIndex = numbers.length / 2;
        int [] leftHalf  = new int [midIndex];
        int [] rightHalf = new int[numbers.length - midIndex];

        for (int i = 0; i < midIndex; i++){
            leftHalf[i] = numbers[i];
        }

        for (int i = midIndex; i < numbers.length; i++){
            rightHalf[i - midIndex] = numbers[i];
        }
// recursively call the funktion it self, to split the array till array has less then two elements 
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(numbers, leftHalf, rightHalf);
    }
// merge the array, i and j are used for iteration through the splitted arrays, and k is used for iteration through merged array.  
    private static void merge(int[] numbers, int[] leftHalf, int[] rightHalf){
        int leftSize  = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize){
            if (leftHalf[i] <= rightHalf[j]){
                numbers[k] = leftHalf[i];
                i++;
            }else{
                numbers[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            numbers[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            numbers[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}
