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
        boolean wonRow = true;
        boolean wonCol = true;
        boolean wonDia = true;
        boolean wonAntiDia = true;


        // rows ->
        for (int cell = 0; cell < board[move.getLeft()].length; cell++) {

          if (!board[move.getLeft()][cell].equals(String.valueOf(player.getPlayerSymbol()))) {
              wonRow = false;
              break;
          }
        }
        if(wonRow)return true;

        // cols ^
        for (int cell = 0; cell < board.length; cell++) {

            if (!board[cell][move.getRight()].equals(String.valueOf(player.getPlayerSymbol()))) {
                wonCol = false;
                break;
            }
        }
        if(wonCol)return true;

        if(move.getRight() == move.getLeft()) {

            // diagonals \
            for (int cell = 0; cell < board[0].length; cell++) {
                if(!board[cell][cell].equals(String.valueOf(player.getPlayerSymbol()))){
                    wonDia = false;
                }
            }
            if(wonDia)return true;

            //antidia /
            for (int cell = 0, antiCell = board[0].length - 1; cell < board.length; cell++,antiCell--){
                if(board[cell][antiCell].equals(String.valueOf(player.getPlayerSymbol()))){
                    wonAntiDia = false;
                }
            }
            if(wonAntiDia)return true;
        }
        return false;
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

