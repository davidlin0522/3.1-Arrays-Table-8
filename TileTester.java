import java.util.Scanner;

public class TileTester {
    public static void main(String[] args) {
        String[][] tileValues = {
            {"A", "B", "C"},
            {"A", "B", "C"}
        };

        Board board = new Board(2, 3);
        
        board.populateBoard(tileValues);

        System.out.println("Initial Gameboard:");
        System.out.println(board.toString());

        Scanner scanner = new Scanner(System.in);

        while (!board.allTilesMatch()) {
            System.out.println(board);
            System.out.print("Enter row and col for first tile (or non-integer to quit): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Game Over.");
                break;
            }
            int r1 = scanner.nextInt();
            int c1 = scanner.nextInt();

            System.out.print("Enter row and col for second tile: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Game Over.");
                break;
            }
            int r2 = scanner.nextInt();
            int c2 = scanner.nextInt();

            board.processTurn(r1, c1, r2, c2);
        }

        if (board.allTilesMatch()) {
            System.out.println("Congratulations! You matched all tiles.");
            System.out.println(board);
        }
        scanner.close();
    }
}