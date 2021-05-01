package test;

public class MissingAndDuplicate {
    public static void swap(int[]arr){
        int i=0;
        while (i < arr.length){
            if(i == arr[i]-1)
                i++;
            else if (arr[i] == arr[arr[i]-1])
                i++;
            else{
                int temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[temp - 1] = temp;
            }
        }
    }
    public static void main(String[] args){
        int[]arr= {2,3,1,8,2, 3, 5, 1};
        swap(arr);
        for(int i=0;i< arr.length;i++){
            if(i != arr[i] - 1){
                System.out.println("Duplicate: " + arr[i]);
                System.out.println("Missing: " + (i+1));
            }
        }
    }
}
