package org.LLD.Actions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Entities.Players;
import org.graalvm.collections.Pair;

@Data
@AllArgsConstructor
@Builder
public class Movement {

    public String[][] placeMove(String[][] board, Pair<Integer,Integer> move, Players player){

        for (int rows = 0; rows < board.length; rows++){
            for (int cols = 0; cols < board[rows].length; cols++){

                if(rows == move.getLeft() && cols == move.getRight()){
                    board[rows][cols] = String.valueOf(player.getPlayerSymbol());
                }
            }
        }
      return board;
    }
}
