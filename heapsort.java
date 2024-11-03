public class heapsort {

    public void sort(int numbers[])
    {
        int N = numbers.length;

        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(numbers, N, i);

        for (int i = N - 1; i > 0; i--) {

            int temp = numbers[0];
            numbers[0] = numbers[i];
            numbers[i] = temp;


            heapify(numbers, i, 0);
        }
    }


    void heapify(int numbers[], int N, int i)
    {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 

        
        if (l < N && numbers[l] > numbers[largest])
            largest = l;

        
        if (r < N && numbers[r] > numbers[largest])
            largest = r;

        
        if (largest != i) {
            int swap = numbers[i];
            numbers[i] = numbers[largest];
            numbers[largest] = swap;

            
            heapify(numbers, N, largest);
        }
    }

    
    static void printArray(int numbers[])
    {
        int N = numbers.length;

        for (int i = 0; i < N; ++i)
            System.out.print(numbers[i] + " ");
        System.out.println();
    }

    
    public static void main(String args[])
    {
        int numbers[] = { 12, 11, 13, 5, 6, 7 };
        int N = numbers.length;

        System.out.println("Unsorted array is");
        printArray(numbers);
        
        heapsort ob = new heapsort();
        ob.sort(numbers);

        System.out.println("Sorted array is");
        printArray(numbers);
    }
}
