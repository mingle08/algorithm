package algo.leetCode;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * For example,
 * Given board =
 *
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 *
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class LeetCode079_WordSearch {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        
        if (word.length() > row * col)
            return false; 
        boolean[][] boardFlag = new boolean[row][col];
        for (int i = 0; i < row; i++) 
            for (int j = 0; j < col; j++)
                if(find(i,j,board,word,boardFlag))
                    return true;
        
        return false;
  
     }
     
     
     
     public boolean find(int i, int j, char[][] board, String word,boolean[][] boardFlag){
  
         // word.charAt(0)  每次都从第一个字符（0下标）开始比较
         if (board[i][j] == word.charAt(0) && !boardFlag[i][j]){
             boardFlag[i][j] = true;
             if (word.length()-1 == 0 ) 
                 return true;
  
             /**
              * word.substring(1,word.length()) 每次匹配到一个字符，就把这个字符（0下标）去掉，从下一个字符开始匹配
              * 即截去第0个字符
              */
             if (j+1 < board[0].length)  // right
                 if(find(i,j+1,board,word.substring(1,word.length()),boardFlag)) 
                     return true;
             if (j-1 >= 0)  // left
                 if(find(i,j-1,board,word.substring(1,word.length()),boardFlag)) 
                     return true;
             if (i+1 < board.length) // down
                 if(find(i+1,j,board,word.substring(1,word.length()),boardFlag)) 
                     return true;
             if (i-1 >= 0)  // up
                 if(find(i-1,j,board,word.substring(1,word.length()),boardFlag)) 
                     return true;
             
             boardFlag[i][j] = false;
         }
         
         return false;
     }
    
    public static void main(String[] args) {
        LeetCode079_WordSearch solution = new LeetCode079_WordSearch();
        char[][] board = {
                          {'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}
                        };
        
        String word = "ABCCED";
        boolean flag = solution.exist(board, word);
        System.out.println(flag);

    }

}
