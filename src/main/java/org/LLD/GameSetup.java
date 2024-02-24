package org.LLD;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Actions.Checks;
import org.LLD.Actions.Movement;
import org.LLD.Entities.Gameboard;
import org.LLD.Entities.Players;
import org.graalvm.collections.Pair;

import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameSetup {
   private Deque<Players> players;
   private String[][] board;
   final Gameboard gameboard = new Gameboard();
   final Checks checks = new Checks();
   final Movement movement = new Movement();


   public void startGame(){

       boolean won = false;
       Scanner scanner = new Scanner(System.in);
       while(!won){
           if(checks.emptyCellLeft(board)) {
               Players player = players.poll();
               System.out.println(player.getPlayerName() + "'s Turn. Play Your Move Now: ");
               String[] input = scanner.nextLine().trim().split(",");
               Pair<Integer, Integer> move = Pair.create(Integer.valueOf(input[0]), Integer.valueOf(input[1]));
               if (checks.validMove(board, move)) {
                   System.out.println("Making Move...");
                   board = movement.placeMove(board, move, player);
                   System.out.println(checks.wonWithMove(board, move, player));
                   if (checks.wonWithMove(board, move, player)) {
                       System.out.println(player.getPlayerName() + " Has Won !!");
                       won = true;
                   }
                   players.offer(player);
                   gameboard.printBoard(board);
               } else {
                   System.out.println("!----- Invalid Move. Cell Not Empty. ----!");
                   players.addFirst(player);
               }
           }
           else {
               System.out.println("There Are No More Empty Cells Left. Khichdi Pak Gayi.");
               won=true;
           }
       }
       System.out.println("***** THANK YOU FOR PLAYING *****");


   }
}
