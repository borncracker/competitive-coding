package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSequenceTest {
    static void powerSet(int input[], int index,
                         Set<Integer> currSet, List<Set<Integer>> allSets)
    {
        int n = input.length;
        // base case
        if (index == n)
        {
            Set<Integer> set = new HashSet<>(currSet);
            allSets.add(set);
            return;
        }
        // Two cases for every character
        // (i) We consider the character
        // as part of current subset
        // (ii) We do not consider current
        // character as part of current
        // subset
        currSet.remove(input[index]);
        powerSet(input, index + 1, currSet, allSets);
        currSet.add(input[index]);
        powerSet(input, index + 1, currSet, allSets);

    }

    public static void main(String args[]){
        int []input = new int[6];
        List<Set<Integer>> allSets = new ArrayList<>();
        for(int i=1;i<=6;i++)
            input[i-1]=i;
        Set<Integer> set = new HashSet<>();
        powerSet(input, 0, set, allSets);
        System.out.println(allSets);
        input = new int[3];
        allSets = new ArrayList<>();
        for(int i=1;i<=3;i++)
            input[i-1]=i;
        set = new HashSet<>();
        powerSet(input, 0, set, allSets);
        System.out.println(allSets);
    }
}
