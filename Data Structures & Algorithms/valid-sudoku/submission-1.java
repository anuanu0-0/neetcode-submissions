class Solution {
    // public boolean isValidSudoku(char[][] board) {
    //     int n = board.length;
    //     int m = board[0].length;
    //     for(int i=0; i<n; i++) {
    //         for(int j=0; j<m; j++) {
    //             if(board[i][j]=='.') continue;
    //             char cur = board[i][j];

    //             // Row check
    //             for(int k=0; k<m; k++) {
    //                 if(k != j && board[i][k]==cur) return false;
    //             }

    //             // Col check
    //             for(int k=0; k<n; k++) {
    //                 if(k != i && board[k][j]==cur) return false;
    //             }

    //             // Grid check 
    //             int row = (i/3)*3;
    //             int col = (j/3)*3;

    //             for(int r=row; r<row+3; r++) {
    //                 for(int c=col; c<col+3; c++) {
    //                     if(board[r][c]==cur && (i!=r || j!=c)) return false;
    //                 }
    //             }
    //         }
    //     }

    //     return true;
    // }


    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j]=='.') continue;

                String key = (i/3)+"#"+(j/3);
                if(rows.computeIfAbsent(i, k->new HashSet<>()).contains(board[i][j]) ||
                    cols.computeIfAbsent(j, k->new HashSet<>()).contains(board[i][j]) ||
                    squares.computeIfAbsent(key, k->new HashSet<>()).contains(board[i][j])
                ) return false;
          
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                squares.get(key).add(board[i][j]);
            }
        }

        return true;
    }
}
