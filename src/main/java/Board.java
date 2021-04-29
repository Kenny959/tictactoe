

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

@NoArgsConstructor
public class Board {
    public final int ROW = 3;
    public final int COL = 3;
    private final Logger logger = Logger.getLogger("Board");
    public char[][] board;
    public Player player;

    public void init() {
        player = new Player(new ArrayList<>(), new ArrayList<>(), PlayerName.PLAYER1);
        board = new char[ROW][COL];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public Player getPlayer() {
        return player;
    }

    public char[][] getBoard() {
        return board;
    }

    public void displayBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " +
                board[0][0] + " | " +
                board[0][1] + " | " +
                board[0][2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " +
                board[1][0] + " | " +
                board[1][1] + " | " +
                board[1][2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " +
                board[2][0] + " | " +
                board[2][1] + " | " +
                board[2][2] + " |");
        System.out.println("|---|---|---|");
    }

    public boolean hasPlayer1Won() {
        List<List<Integer>> combination = getCombination();
        boolean result = false;
        for (List<Integer> list : combination) {
            if (player.getPlayer1Positions().containsAll(list)) {
                logger.info(PlayerName.PLAYER1 + " wins !");
                result = true;
                break;
            }
        }
        return result;
    }
    public boolean hasPlayer2Won() {
        List<List<Integer>> combination = getCombination();
        boolean result = false;
        for (List<Integer> list : combination) {
            if (player.getPlayer2Positions().containsAll(list)) {
                logger.info(PlayerName.PLAYER2 + " wins !");
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean isTied() {
        boolean result = false;
        if (player.getPlayer1Positions().size() + player.getPlayer2Positions().size() == 9) {
            logger.info("Game Tied !");
            result = true;
        }
        return result;
    }


    public List<List<Integer>> getCombination() {
        List<List<Integer>> combination = new ArrayList<>();
        combination.add(Arrays.asList(1, 2, 3));
        combination.add(Arrays.asList(4, 5, 6));
        combination.add(Arrays.asList(7, 8, 9));
        combination.add(Arrays.asList(1, 4, 7));
        combination.add(Arrays.asList(2, 5, 8));
        combination.add(Arrays.asList(3, 6, 9));
        combination.add(Arrays.asList(1, 5, 9));
        combination.add(Arrays.asList(3, 5, 7));

        return combination;
    }

    public void insertPosition(int position, Player player) {
        char playerSymbol;
        if (PlayerName.PLAYER1 == player.getPlayerName()) {
            playerSymbol = 'X';
            player.getPlayer1Positions().add(position);
        } else {
            playerSymbol = '0';
            player.getPlayer2Positions().add(position);
        }

        switch (position) {
            case 1:
                board[0][0] = playerSymbol;
                break;
            case 2:
                board[0][1] = playerSymbol;
                break;
            case 3:
                board[0][2] = playerSymbol;
                break;
            case 4:
                board[1][0] = playerSymbol;
                break;
            case 5:
                board[1][1] = playerSymbol;
                break;
            case 6:
                board[1][2] = playerSymbol;
                break;
            case 7:
                board[2][0] = playerSymbol;
                break;
            case 8:
                board[2][1] = playerSymbol;
                break;
            case 9:
                board[2][2] = playerSymbol;
                break;
            default:
                break;
        }
    }

    public void start() {
        displayBoard();
        Scanner in = new Scanner(System.in);
        while (!hasPlayer1Won() && !hasPlayer2Won() && !isTied()) {
            System.out.println(player.getPlayerName() + ", please, enter your position (1 to 9): ");
            int position = in.nextInt();
            while (isPositionTaken(position) || isOutOfBounds(position)) {
                if (isPositionTaken(position)) {
                    logger.warning("Position already taken, please try again :");
                } else if (isOutOfBounds(position)) {
                    logger.warning("Position out of bounds, please try again :");
                }
                position = in.nextInt();
            }
            insertPosition(position, player);
            displayBoard();
            player.switchPlayer();
        }
    }

    public boolean isOutOfBounds(int position) {
        return position < 1 || position > 9;
    }

    public boolean isPositionTaken(int position) {
        return player.getPlayer1Positions().contains(position) || player.getPlayer2Positions().contains(position);
    }
}
