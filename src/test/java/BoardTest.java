
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class BoardTest {

    @Test
    public void initTest() {
        // Arrange
        char[][] boardTest = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardTest[i][j] = ' ';
            }
        }

        // Act
        Board board = new Board();
        board.init();

        // Assert
        Assertions.assertEquals(3, board.getBoard().length);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Assertions.assertEquals(board.getBoard()[i][j], boardTest[i][j]);
            }
        }
        Assertions.assertNotNull(board.getPlayer());
        Assertions.assertEquals(board.getPlayer().getPlayer1Positions(), new ArrayList<Integer>());
        Assertions.assertEquals(board.getPlayer().getPlayer2Positions(), new ArrayList<Integer>());
        Assertions.assertEquals(board.getPlayer().getPlayerName(), PlayerName.PLAYER1);
    }


    @Test
    public void getBoardTest() {
        // Arrange
        Board board = new Board();
        board.init();

        // Act
        char[][] board1 = board.getBoard();

        // Assert
        Assertions.assertNotNull(board1);
    }

    @Test
    public void getPlayerTest() {
        // Arrange
        Board board = new Board();
        board.init();

        // Act
        Player player = board.getPlayer();

        // Assert
        Assertions.assertNotNull(player);
    }

    @Test
    public void isTiedTest() {
        // Arrange
        Board board = new Board();
        board.init();
        ArrayList<Integer> play1Pos = new ArrayList<Integer>() {
            {
                add(1);
                add(3);
                add(4);
                add(5);
                add(8);
            }
        };

        ArrayList<Integer> play2Pos = new ArrayList<Integer>() {
            {
                add(2);
                add(6);
                add(7);
                add(9);
            }
        };
        board.getPlayer().setPlayer1Positions(play1Pos);
        board.getPlayer().setPlayer2Positions(play2Pos);

        // Act
        boolean result = board.isTied();

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void isPlayer1WonTest() {
        // Arrange
        Board board = new Board();
        board.init();
        ArrayList<Integer> play1Pos = new ArrayList<Integer>() {
            {
                add(1);
                add(5);
                add(9);
            }
        };

        ArrayList<Integer> play2Pos = new ArrayList<Integer>() {
            {
                add(2);
                add(6);
            }
        };
        board.getPlayer().setPlayer1Positions(play1Pos);
        board.getPlayer().setPlayer2Positions(play2Pos);

        // Act
        boolean result = board.hasPlayer1Won();

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void isPlayer2WonTest() {
        // Arrange
        Board board = new Board();
        board.init();
        ArrayList<Integer> play1Pos = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(9);
            }
        };

        ArrayList<Integer> play2Pos = new ArrayList<Integer>() {
            {
                add(4);
                add(5);
                add(6);
            }
        };
        board.getPlayer().setPlayer1Positions(play1Pos);
        board.getPlayer().setPlayer2Positions(play2Pos);

        // Act
        boolean result = board.hasPlayer2Won();

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void insertPositionIsOkTest() {
        // Arrange
        Board board = new Board();
        board.init();


        // Act
        board.insertPosition(1, board.getPlayer());

        // Assert
        Assertions.assertEquals(board.getBoard()[0][0], 'X');
    }

    @Test
    public void isPositionTakenTrueTest() {
        // Arrange
        Board board = new Board();
        board.init();

        ArrayList<Integer> play1Pos = new ArrayList<Integer>() {
            {
                add(1);
                add(5);
                add(6);
            }
        };
        board.getPlayer().setPlayer1Positions(play1Pos);


        // Act
        boolean positionTaken = board.isPositionTaken(1);

        // Assert
        Assertions.assertTrue(positionTaken);
    }
    @Test
    public void isPositionTakenFalseTest() {
        // Arrange
        Board board = new Board();
        board.init();

        ArrayList<Integer> play1Pos = new ArrayList<Integer>() {
            {
                add(1);
                add(5);
                add(6);
            }
        };
        board.getPlayer().setPlayer1Positions(play1Pos);


        // Act
        boolean positionTaken = board.isPositionTaken(4);

        // Assert
        Assertions.assertFalse(positionTaken);
    }

    @Test
    public void isOutOfBoundsTrueTest() {
        // Arrange
        Board board = new Board();
        board.init();

        // Act
        boolean positionTaken = board.isOutOfBounds(10);

        // Assert
        Assertions.assertTrue(positionTaken);
    }

    @Test
    public void isOutOfBoundsFalseTest() {
        // Arrange
        Board board = new Board();
        board.init();

        // Act
        boolean positionTaken = board.isOutOfBounds(1);

        // Assert
        Assertions.assertFalse(positionTaken);
    }
}
