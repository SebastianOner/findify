package CodeBase;

public class MineSweeper {
    private int[][] myTruth;
    private boolean[][] myShow;

    //Picks cell at specific location
    public void cellPicked(int row, int col) {
        if (inBounds(row, col) && !myShow[row][col]) {
            myShow[row][col] = true;

            if (myTruth[row][col] == 0) {
                for (int r = -1; r <= 1; r++)
                    for (int c = -1; c <= 1; c++)
                        cellPicked(row + r, col + c);
            }
        }
    }
    //returns, if position is correct
    public boolean inBounds(int row, int col) {
        return 0 <= row && row < myTruth.length && 0 <= col && col < myTruth[0].length;
    }
}