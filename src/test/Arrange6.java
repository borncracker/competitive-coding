package test;

public class Arrange6 {

    // Prints max at first position, min at second
    // position second max at third position, second
    // min at fourth position and so on.
    public static void rearrange(int arr[], int n)
    {
        // initialize index of first minimum and first
        // maximum element
        int max_idx = n - 1, min_idx = 0;

        // Can be anything greater than max element
        // otherwise we will not be able to retrieve the original value.
        // you can verify it.
        int constant = arr[n - 1] +1;

        // traverse array elements
        for (int i = 0; i < n; i++) {
            // at even index : we have to put
            // maximum element
            if (i % 2 == 0) {
                arr[i] += (arr[max_idx] % constant) * constant;
                max_idx--;
            }

            // at odd index : we have to put minimum element
            else {
                arr[i] += (arr[min_idx] % constant) * constant;
                min_idx++;
            }
        }

        // array elements back to it's original form
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] / constant;
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int n = arr.length;

        System.out.println("Original Array");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        rearrange(arr, n);

        System.out.print("\nModified Array\n");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}

// This code is contributed by Swetank Modi
