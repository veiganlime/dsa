import java.util.Arrays;
import java.util.Random;

public class binarysearch {
    public static void main(String[] args){
        // int numbers[] = new int[100];
        // Random random = new Random();

        // for(int i = 0; i < numbers.length; i++){
        //     numbers[i] = random.nextInt(1000);
        // }
        //System.out.println(Arrays.toString(numbers));
        long startTime = System.currentTimeMillis();
        
        int numbers[] = {1,2,4,5,7,9,11};
        int numberToFind = 11;
        System.out.println(binarySearch(numbers, numberToFind));
        
        long endTime = System.currentTimeMillis();        
        //System.out.println(Arrays.toString(numbers));
        System.out.println("Took " + (endTime - startTime) + "ms");
    }


    private static int binarySearch(int[] numbers, int numberToFind) {
        int low = 0;
        int high = numbers.length-1;

        while (low <= high) {
            int middlePosition = (low + high) / 2;
            int middleNumber = numbers[middlePosition];

            if (numberToFind == middleNumber){
                return middlePosition;
            }
            if (numberToFind < middleNumber){
                high = middlePosition -1;
            }else{
                low = middlePosition +1;
            }
 
        }
        return -1;
    }
}
