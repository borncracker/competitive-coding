package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Boggle {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for(String word: words){
            if(exist(board, word))
                result.add(word);
        }
        return result;
    }
    public boolean exist(char[][]board, String word){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0) == board[i][j] && wordUtil(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    int[] rowMove = {0, -1, 0, 1};
    int[] colMove = {-1, 0, 1, 0};
    public boolean wordUtil(char[][]board, String words, int row, int col, int steps){
        if(words.length()== steps+1){
            return true;
        }
        for(int i =0;i<rowMove.length;i++){
            int newRow = row + rowMove[i];
            int newCol = col + colMove[i];
            if(isValid(board, row, col, words, steps)) {
                char temp = board[row][col];
                board[row][col] = ' ';
                if (wordUtil(board, words, newRow, newCol, steps + 1)) {
                    board[row][col] = temp;
                    return true;
                }
                board[row][col] = temp;
            }
        }
        return false;
    }

    private boolean isValid(char[][]board, int row, int col, String word, int steps){
        if(row < board.length && row >=0 && col >= 0 && col < board[0].length && (word.charAt(steps) == board[row][col])){
            return true;
        }
        return false;
    }

    public static void main(String[]args){
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        Boggle boggle = new Boggle();
        System.out.println(boggle.findWords(board,words));
    }
}