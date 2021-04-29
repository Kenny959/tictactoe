


import java.util.ArrayList;

public class Player {
    private ArrayList<Integer> player1Positions;
    private ArrayList<Integer> player2Positions;
    private PlayerName playerName;

    public Player(ArrayList<Integer> player1Positions, ArrayList<Integer> player2Positions, PlayerName playerName) {
        this.player1Positions = player1Positions;
        this.player2Positions = player2Positions;
        this.playerName = playerName;
    }

    public ArrayList<Integer> getPlayer1Positions() {
        return player1Positions;
    }

    public ArrayList<Integer> getPlayer2Positions() {
        return player2Positions;
    }

    public void setPlayer1Positions(ArrayList<Integer> player1Positions) {
        this.player1Positions = player1Positions;
    }

    public void setPlayer2Positions(ArrayList<Integer> player2Positions) {
        this.player2Positions = player2Positions;
    }

    public PlayerName getPlayerName() {
        return playerName;
    }

    public void switchPlayer() {
        if (PlayerName.PLAYER1 == playerName) {
            playerName = PlayerName.PLAYER2;
        } else {
            playerName = PlayerName.PLAYER1;
        }
    }
}
