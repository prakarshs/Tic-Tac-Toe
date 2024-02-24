package org.LLD.Actions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Entities.Players;
import org.graalvm.collections.Pair;

@AllArgsConstructor
@Builder
@Data
public class Checks {

    public boolean validMove(String[][] board, Pair<Integer, Integer> move) {

        for (int rows = 0; rows < board.length; rows++) {
            for (int cols = 0; cols < board[rows].length; cols++) {

                if (rows == move.getLeft() && cols == move.getRight()){

                    if (!board[rows][cols].equals("-")) return false;

                }
            }
        }
        return true;
    }


    public boolean wonWithMove(String[][] board,Pair<Integer, Integer> move, Players player) {
        boolean won = true;
        // rows ->
        System.out.println("for row check win");
        for (int cell = 0; cell < board[move.getLeft()].length; cell++) {

          if (!board[move.getLeft()][cell].equals(String.valueOf(player.getPlayerSymbol()))) {
              won = false;
          }
        }

        // cols ^
        System.out.println("for col check win");
        for (int cell = 0; cell < board.length; cell++) {

            if (!board[cell][move.getRight()].equals(player.getPlayerSymbol())) {
                won = false;
            }
        }

        return won;
    }



    public boolean emptyCellLeft(String[][] board) {
        for (int rows = 0; rows < board.length; rows++) {
            for (int cols = 0; cols < board[rows].length; cols++) {
                if(board[rows][cols].equals("-")) return true;
            }
        }
        return false;
    }
}

