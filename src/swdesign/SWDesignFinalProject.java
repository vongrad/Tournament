/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swdesign;

import java.util.ArrayList;
import org.omg.SendingContext.RunTime;
import swdesign.builder.IMatchBuilder;
import swdesign.builder.MatchBuilderImp;
import swdesign.examplegames.stupidnumbergame.StupidNumberGame;
import swdesign.examplegames.stupidnumbergame.StupidNumberPlayer;
import swdesign.examplegames.stupidnumbergame.players.ConstantPlayer;
import swdesign.examplegames.stupidnumbergame.players.RandomPlayer;
import swdesign.game.AI;
import swdesign.game.Game;
import swdesign.gameListeners.ITournamentListener;
import swdesign.gameListeners.TournamentEvent;
import swdesign.tournament.ParticipantInfo;
import swdesign.tournament.Tournament;

/**
 *
 * @author tog
 */
public class SWDesignFinalProject implements ITournamentListener {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        Tournament<StupidNumberPlayer> tournament = new Tournament(runtime.availableProcessors());
        
        Game game = new StupidNumberGame(10);
        StupidNumberPlayer[] players = new StupidNumberPlayer[6];

        StupidNumberPlayer a = new RandomPlayer("a", "a", 10, 20);
        StupidNumberPlayer b = new RandomPlayer("b", "b", 90, 180);
        StupidNumberPlayer c = new RandomPlayer("c", "c", 8, 120);
        StupidNumberPlayer d = new RandomPlayer("d", "d", 7, 200);
        StupidNumberPlayer e = new RandomPlayer("e", "e", 6, 89);
        StupidNumberPlayer z = new RandomPlayer("z", "z", 5, 47);
        StupidNumberPlayer[] list = new StupidNumberPlayer[6];
        players[0] = (a);
        players[1] = (b);
        players[2] = (c);
        players[3] = (d);
        players[4] = (e);
        players[5] = (z);

        tournament.tournamentStart(game, players);
    }

    @Override
    public void gameUpdate(TournamentEvent event) {
        if (event.getType() != TournamentEvent.TYPE_TOURNAMENT_ENDED) {
            System.out.println("Message: " + event.getMessage());
        } else {
            for (ParticipantInfo participantInfo : event.getParticipants()) {
                System.out.println("Name: " + participantInfo.getName() + " score: " + participantInfo.getScore());
            }
        }
    }

}
