package org.LLD;

import org.LLD.Entities.Gameboard;
import org.LLD.Entities.Players;
import org.LLD.Enums.PlayerSymbol;

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {

        System.out.println("HELLO GAME IS STARTING..");

        Gameboard gameboard = new Gameboard();
        String[][] board = gameboard.generateBoard(3,3);

        System.out.println(Arrays.deepToString(board));

        Players player1 = Players.builder()
                .playerName("Vasu")
                .playerSymbol(PlayerSymbol.X)
                .build();
        Players player2 = Players.builder()
                .playerName("Pari")
                .playerSymbol(PlayerSymbol.O)
                .build();

        Deque<Players> players = new ArrayDeque<>();
        players.add(player1);
        players.add(player2);

        GameSetup gameSetup = GameSetup.builder()
                .players(players)
                .board(board)
                .build();

        gameSetup.startGame();



    }
}