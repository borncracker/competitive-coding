package test;

// Java program to print largest contiguous
// array sum
import java.io.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class KadaneAlgorithm {
    static int maxSubArraySum(int a[], int size)
    {
        int max_so_far = a[0];
        int curr_max = a[0];
        int start =0, end=0;
        for (int i = 1; i < size; i++)
        {
           // curr_max = Math.max(a[i], curr_max+a[i]);
            if(a[i] >= curr_max+a[i]){
                curr_max = a[i];
                start = i;
            }else{
                curr_max += a[i];
            }
            if(max_so_far < curr_max){
                max_so_far = curr_max;
                end = i;
            }
      //      max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }

    /* Driver program to test maxSubArraySum */
    public static void main(String[] args)
    {
        int a[] = {9, -8, 10, -4, 1, -8, -1, 6, 5, 2};
        int n = a.length;
        int max_sum = maxSubArraySum(a, n);
        System.out.println("Maximum contiguous sum is "
                + max_sum);
    }
}

// This code is contributd by Prerna Saini
