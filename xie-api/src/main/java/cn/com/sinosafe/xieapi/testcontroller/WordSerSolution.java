package cn.com.sinosafe.xieapi.testcontroller;


/**
 * Created by xiehanchun on 2020/7/13
 */
public class WordSerSolution {
    private char[][] board;
    private String word;
    private int m;
    private int n;
    private boolean[][] marked;
    /**
     * x,y-1
     * x-1,y  x,y  x+1, y
     * x,y+1
     */
    private int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        this.board = board;
        this.word = word;
        marked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x,int y,int status) {
//        if(status == word.length()){
//            return board[x][y] == word.charAt(status);
//        }
        if(status == word.length() - 1){
            return board[x][y] == word.charAt(status);
        }
        if(board[x][y] == word.charAt(status)){
//            marked[x][y] = true;
            for(int i = 0 ; i < 4; i++){
                int newX = x + direction[i][0];
                int newY = y + direction[i][1];
                if(inArea(newX,newY) && !marked[newX][newY]){
                    if(dfs(newX,newY,status+1)){
                        return true;
                    }
                }
            }
//            marked[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int newX, int newY) {
        return newX >= 0 && newX < m && newY >= 0 && newY < n;
    }

}
