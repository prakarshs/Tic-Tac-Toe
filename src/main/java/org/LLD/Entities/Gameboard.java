package org.LLD.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class Gameboard {

    public String[][] generateBoard(Integer numberOfRows, Integer numberOfCols){

        String[][] board = new String[numberOfRows][numberOfCols];

        for (int rows = 0; rows < numberOfRows; rows++){

            for (int cols = 0; cols < numberOfCols; cols++){

                board[rows][cols] = "-";
            }
        }
      return board;
    }

    public void printBoard(String[][] board){

        for (int rows = 0; rows < board.length; rows++){

            for (int cols = 0; cols < board[rows].length; cols++){

                System.out.print(board[rows][cols]+" ");
            }
            System.out.println("\n");
        }
    }
}
