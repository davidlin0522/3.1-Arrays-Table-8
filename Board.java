public class Board {
    private Tile[][] gameboard;

    public Board(int rows, int cols) {
        gameboard = new Tile[rows][cols];
    }

    public void populateBoard(String[][] tileValues) {
        for (int r = 0; r < gameboard.length; r++) {
            for (int c = 0; c < gameboard[0].length; c++) {
                gameboard[r][c] = new Tile(tileValues[r][c]);
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int r = 0; r < gameboard.length; r++) {
            for (int c = 0; c < gameboard[0].length; c++) {
                result += gameboard[r][c].toString() + " ";
            }
            result += "\n";
        }
        return result;
    }

    public boolean allTilesMatch() {
        for (int r = 0; r < gameboard.length; r++) {
            for (int c = 0; c < gameboard[0].length; c++) {
                if (!gameboard[r][c].isMatched()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean processTurn(int r1, int c1, int r2, int c2) {
        if (r1 < 0 || r1 >= gameboard.length || c1 < 0 || c1 >= gameboard[0].length ||
            r2 < 0 || r2 >= gameboard.length || c2 < 0 || c2 >= gameboard[0].length) {
            System.out.println("Invalid input: Index out of bounds.");
            return false;
        }

        if (gameboard[r1][c1].isMatched() || gameboard[r2][c2].isMatched()) {
            System.out.println("One or both chosen tiles are already matched!");
            return false;
        }

        if (gameboard[r1][c1].getValue().equals(gameboard[r2][c2].getValue())) {
            System.out.println("Match found!");
            gameboard[r1][c1].setMatched(true);
            gameboard[r2][c2].setMatched(true);
            return true;
        } else {
            System.out.println("No match. Try again.");
            return false;
        }
    }
}