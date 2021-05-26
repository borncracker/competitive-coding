package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    public List<List<String>> wordLadder(String src, String dest, Set<String> dict){
        List<List<String> > result = new ArrayList<>();
        Set<String > visited = new HashSet<>();
        backtrackingUtil(src,dest,new ArrayList<>(), result,visited, dict);
        return result;
    }
    public void backtrackingUtil(String src, String dest, List<String> intermediateResult, List<List<String>> result, Set<String> visited, Set<String>dict){
        intermediateResult.add(src);
        visited.add(src);
        if (src.equals(dest)){
            result.add(new ArrayList(intermediateResult));
            return;
        }
        List<String> possibleString = new ArrayList<>();
        for(int i=0;i<src.length();i++) {
            for (int j = 0; j < 26; j++) {
                String newWord = getWord(src, i, j);
                if (!visited.contains(newWord) && dict.contains(newWord)) {
                    possibleString.add(newWord);
                    visited.add(newWord);
                }
            }
        }
        for (String newWord: possibleString) {
            backtrackingUtil(newWord, dest, intermediateResult, result, visited, dict);
            intermediateResult.remove(newWord);
        }
    }
    String getWord(String src, int i, int j){
        char ch = (char)(j+'a');
        char[]srcArray = src.toCharArray();
        srcArray[i]= ch;
        return String.valueOf(srcArray);
    }
    public static void main(String[]args){
        String[] wordList = {"hot","dot","dog","lot","log", "cog", "bot", "bog"};
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(Arrays.asList(wordList));
        WordLadder wl = new WordLadder();
        List<List<String>> result = wl.wordLadder("hit", "cog", wordSet);
        System.out.print(result);
    }
}
