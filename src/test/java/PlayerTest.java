import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PlayerTest {

    @Test
    public void getPlayer1PositionsTest() {
        // Arrange
        Player player = new Player(new ArrayList<>(), new ArrayList<>(), PlayerName.PLAYER1);

        // Act
        ArrayList<Integer> player1Positions = player.getPlayer1Positions();

        // Assert
        Assertions.assertNotNull(player1Positions);
    }

    @Test
    public void getPlayer2PositionsTest() {
        // Arrange
        Player player = new Player(new ArrayList<>(), new ArrayList<>(), PlayerName.PLAYER1);

        // Act
        ArrayList<Integer> player2Positions = player.getPlayer2Positions();

        // Assert
        Assertions.assertNotNull(player2Positions);
    }

    @Test
    public void getPlayerNameTest() {
        // Arrange
        Player player = new Player(new ArrayList<>(), new ArrayList<>(), PlayerName.PLAYER1);

        // Act
        PlayerName playerName = player.getPlayerName();

        // Assert
        Assertions.assertSame(player.getPlayerName(), PlayerName.PLAYER2);
    }

    @Test
    public void switchPlayerToPlayer1Test() {
        // Arrange
        Player player = new Player(new ArrayList<>(), new ArrayList<>(), PlayerName.PLAYER2);

        // Act
        player.switchPlayer();

        // Assert
        Assertions.assertSame(player.getPlayerName(), PlayerName.PLAYER1);
    }

    @Test
    public void switchPlayerToPlayer2Test() {
        // Arrange
        Player player = new Player(new ArrayList<>(), new ArrayList<>(), PlayerName.PLAYER1);

        // Act
        player.switchPlayer();

        // Assert
        Assertions.assertSame(player.getPlayerName(), PlayerName.PLAYER2);
    }
}
