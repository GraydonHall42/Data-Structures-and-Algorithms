import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

public class SortComparison {

    int inputArray[];
    private BufferedReader reader;  // used to get user input
    String order;
    int size;
    String alg;
    String fileName;

    public static void main(String[] args) {

        // code to test program:
        // note: MUST COMMENT OUT CODE IN getUserInput() TO USE THIS FOR TESTING
//        var types = new String[]{"ascending", "descending", "random"};
//        for (int j = 0; j < types.length; j++) {
//            for (int i = 1; i <= 6; i++) {
//
//                var s = new SortComparison();
//                s.size = (int) Math.pow(10, i);
//                s.order = types[j];
//                s.alg = "merge";
//                s.generateArray();  // obtain user input and create input array
//
//                long start = System.currentTimeMillis();  // start time
//                s.sortArray();  // sort array and output to txt file
//                long end = System.currentTimeMillis();  // end timer
//
//                System.out.println("------ Summary Information ------");
//                System.out.println("Algorithm used: : " + s.alg + " sort algorithm");
//                System.out.println("Sorting time: " + (end - start) + "ms");
//                System.out.println("Array Length: " + s.size);
//                System.out.println("Order of input array: " + s.order);
//                System.out.println("Sorted array is saved as: " + s.fileName + "\n");
//            }
//        }

        // for normal use:
        var s = new SortComparison();
        s.generateArray();  // obtain user input and create input array
        long start = System.currentTimeMillis();  // start time
        s.sortArray();  // sort array and output to txt file
        long end = System.currentTimeMillis();  // end timer
        s.writeToFile();
        var time = (end - start);
        System.out.println("Sorting time: " + time + "ms (" + (double)time/1000 + " seconds)");


    }

    public void generateArray(){
        getUserInput();  // get array specifications

        // initalize array of random integers to be sorted
        // use java streams to generate an array of size elements, with integers between 0 and size.
        // https://stackoverflow.com/questions/28970799/how-to-create-a-array-with-n-random-integers/44487538
        // accessed: 2021-07-12
        inputArray = IntStream.generate(() -> new Random().nextInt(size)).limit(size).toArray();

        if(order.equals("ascending")){
            // put in ascending order
            Arrays.sort(inputArray);
        }
        else if (order.equals("descending")){
            // use java streams to reverse the order of the array
            // https://stackoverflow.com/questions/1694751/java-array-sort-descending
            inputArray = Arrays.stream(inputArray).boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();
        }

        // if we want to verify array contents;
        // System.out.println(Arrays.toString(inputArray));

    }

    private void getUserInput(){

        // get following input: order, size, sorting algorithm, and output file name.
        reader = new BufferedReader(new InputStreamReader(System.in));  // initialize keyboard reader

        // get order of array
        System.out.println("Order of input array (ascending, descending, or random): ");
        order = readKeyboard();

        // get size of array
        System.out.println("Enter size of array as an integer");
        size = getKeyboardInteger();

        // sorting algorithm
        System.out.println("Sorting algorithm to test (bubble, insertion, merge, or quick): ");
        alg = readKeyboard();

        // output file name
        System.out.println("Enter name of the output file where the sorted list will be written to");
        fileName = readKeyboard();

    }

    public void sortArray(){

        // sort input array based on specified algorithm
        switch(alg) {
            case "bubble":
                bubbleSort();
                break;
            case "insertion":
                insertionSort();
                break;
            case "merge":
                mergeSort(inputArray, inputArray.length);
                break;
            case "quick":
                quickSort(inputArray, 0, inputArray.length-1);
                break;
        }

    }



    private void writeToFile(){

        // create file or verify existence
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                ;
//                System.out.println("File created: " + myObj.getName());
            } else {
                ;
//                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // write to file
        try
        {
            PrintWriter pr = new PrintWriter(fileName);

            for (int j : inputArray) {
                pr.println(j);
            }
            pr.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }



    }

    private void insertionSort() {
        // https://www.geeksforgeeks.org/insertion-sort/
        // accessed: 2021-07-12
        // author: Rajat Mishra
        int n = inputArray.length;
        for (int i = 1; i < n; ++i) {
            int key = inputArray[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && inputArray[j] > key) {
                inputArray[j + 1] = inputArray[j];
                j = j - 1;
            }
            inputArray[j + 1] = key;
        }
    }

    private void bubbleSort(){
        // https://www.geeksforgeeks.org/bubble-sort/
        // accessed: 2021-07-12
        // author: Rajat Mishra
        int n = inputArray.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (inputArray[j] > inputArray[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j+1];
                    inputArray[j+1] = temp;
                }
    }

    private String readKeyboard(){
        String line = "";
        try{
            line = reader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        return line;
    }

    public int getKeyboardInteger(){
        return Integer.parseInt(readKeyboard());
    }

    public void mergeSort(int[] a, int n) {
        // https://www.baeldung.com/java-merge-sort
        // accessed: 2021-07-12
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    // used in merge sort code
    public void merge(int[] a, int[] l, int[] r, int left, int right) {
        // https://www.baeldung.com/java-merge-sort
        // accessed: 2021-07-12
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    // ********** quicksort code **********//
    // https://www.geeksforgeeks.org/iterative-quick-sort/
    // accessed: 2021-07-12

     /* This function takes last element as pivot,
    places the pivot element at its correct
    position in sorted array, and places all
    smaller (smaller than pivot) to left of
    pivot and all greater elements to right
    of pivot */
    public int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];

        // index of smaller element
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /* A[] --> Array to be sorted,
l --> Starting index,
h --> Ending index */
    public void quickSort(int arr[], int l, int h)
    {
        // Create an auxiliary stack
        int[] stack = new int[h - l + 1];

        // initialize top of stack
        int top = -1;

        // push initial values of l and h to stack
        stack[++top] = l;
        stack[++top] = h;

        // Keep popping from stack while is not empty
        while (top >= 0) {
            // Pop h and l
            h = stack[top--];
            l = stack[top--];

            // Set pivot element at its correct position
            // in sorted array
            int p = partition(arr, l, h);

            // If there are elements on left side of pivot,
            // then push left side to stack
            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            // If there are elements on right side of pivot,
            // then push right side to stack
            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    }

}
