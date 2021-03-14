package com.shravan.learn.problems.medium.backtracking;

public class SearchWord {
    boolean[][] visited;

    public static void main(String[] args) {
        SearchWord solution = new SearchWord();
        boolean see = solution.exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        }, "SEE");
        System.out.println("see = " + see);
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (word.charAt(0) == board[i][j] && searchWord(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchWord(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || word.charAt(index) != board[i][j] || visited[i][j])
            return false;
        visited[i][j] = true;
        if (searchWord(board, word, i + 1, j, index + 1) ||
                searchWord(board, word, i - 1, j, index + 1) ||
                searchWord(board, word, i, j + 1, index + 1) ||
                searchWord(board, word, i, j - 1, index + 1))
            return true;
        visited[i][j] = false;
        return false;
    }
}
