# Tic Tac Toe Game

TICTACTOE CLI in Java.

## Set up

Run `mvn clean install` to install dependencies

## Run

This game contains an array numbered from 1 to 9 (from left to right and top to bottom) <br/>
`|-----|`<br/>
`|1|2|3|`<br/>
`|4|5|6|`<br/>
`|7|8|9|`<br/>
`|-----|`<br/>

At prompt, Player1 (P1) will be asked to enter his position. <br/>
If P1 enters a position which is not free (already taken) OR out of bounds of the playGrid, then an alert will be launched and will ask for retry <br/>

The game will continue and switch between PlayerOne ('X') and Player2 ('O') until one of these three condition is met <br/>
 - Player1 wins if one of the winning condition is met
 - Player2 wins if one of the winning condition is met
 - if no one has won and board is full (means the sum of *player1Positions* and *player2Positions* is 9)

After displaying the result, the game stops ! 

## How to start the game
To start the game, just run the main class `TicTacToe`.
In the opened console, follow the instructions to enter the values.

## Winning conditions

Player wins the game if one of these three condition is met : <br/>
 - 3 same symbols ('X' or 'O') are aligned horizontally (i.e. in position 1,2,3 OR 3,2,1 OR 4,5,6 OR 6,5,4 OR 7,8,9 OR 9,8,7),
 - 3 same symbols ('X' or 'O') are aligned vertically (i.e. in position 1,4,7 OR 7,4,1 OR 2,5,8 OR 8,5,2 OR 3,6,9 OR 9,6,3),
 - 3 same symbols ('X' or 'O') are aligned in diagonal (i.e. in position 1,5,9 OR 9,5,1 OR 3,5,7 OR 7,5,3),

## Tests

Use `mvn test` to run the tests.