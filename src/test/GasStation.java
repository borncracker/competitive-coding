package test;

import java.util.HashMap;
import java.util.Map;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, gas_sum=0, cost_sum = 0;

        for(int i=0;i<n;i++){
            gas_sum += gas[i];
            cost_sum += cost[i];

            gas[i] -= cost[i];            //creating array for kadane algo
        }

        if(cost_sum>gas_sum) return(-1);
        //kadane implementaion
        int idx=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum += gas[i];
            if(sum<0){
                sum=0;
                idx = i+1;
            }
        }
        return idx;
    }
    public static void main(String[] args){
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
