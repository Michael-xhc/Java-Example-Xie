package cn.com.sinosafe.xieapi.testcontroller;


/**
 * Created by xiehanchun on 2020/7/13
 */
public class WordSerSolution {
    private boolean[][] marked;
    private char[][] board;
    private String word;
    private int m;
    private int n;
    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y
    private static int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public boolean exist(char[][] board,String word){
        if(board.length==0){
            return false;
        }
        //横长
        this.m = board.length;
        //纵长
        this.n = board[0].length;
        this.word = word;
        this.board = board;
        marked = new boolean[m][n];

        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(i,j,0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int x, int y, int start) {
        if(start == word.length() - 1){
            return board[x][y] == word.charAt(start);
        }
        marked[x][y] = true;
        if(board[x][y] == word.charAt(start)){
            for(int i = 0; i < 4 ; i++){
                int newX = x + direction[i][0];
                int newY = y + direction[i][1];
                if(inArea(newX,newY) && !marked[newX][newY]){
                    if(dfs(newX,newY,start+1)){
                        return true;
                    }
                }
            }
            marked[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
