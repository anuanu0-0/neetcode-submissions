class Solution {
    private boolean search(int index, String word, int x, int y, char[][] board) {
        int n = board.length-1;
        int m = board[0].length-1;

        if(x<0 || x>n || y<0 || y>m || board[x][y]!=word.charAt(index)) return false;
        if(index==word.length()-1) return true;

        char cur = board[x][y];
        board[x][y]='#';
        boolean ans = search(index+1, word, x, y+1, board) 
                || search(index+1, word, x+1, y, board)
                || search(index+1, word, x, y-1, board)
                || search(index+1, word, x-1, y, board);
        board[x][y]=cur;

        return ans;
    }

    public boolean exist(char[][] board, String word) {
        char first = word.charAt(0);
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j]==first && search(0, word, i, j, board)) {
                    return true;
                }
            }
        }

        return false;
    }
}
