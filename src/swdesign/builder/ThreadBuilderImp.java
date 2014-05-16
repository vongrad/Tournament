/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swdesign.builder;

import com.sun.javafx.geom.Crossings;
import swdesign.game.Game;
import swdesign.game.GameInstance.Result;
import swdesign.gameListeners.Constants;
import swdesign.gameListeners.TournamentEvent;
import swdesign.tournament.MatchInfo;
import swdesign.tournament.ParticipantImp;
import swdesign.tournament.Tournament;

/**
 *
 * @author adamv_000
 */
public class ThreadBuilderImp implements IThreadBuilder{

    @Override
    public Thread buildThread(Tournament tournament) {
        return new Thread(){

            @Override
            public void run() {
                
                MatchInfo match;
                Game game = tournament.getGame();
                Result result;
                
                while((match = tournament.getNextMatch()) != null){
                    result = game.newInstance().playGame(((ParticipantImp)match.getParticipantA()).newInstance(), ((ParticipantImp)match.getParticipantB()).newInstance());
                    tournament.notifyListeners(new TournamentEvent(Constants.MATCH_START.replace("{name1}", match.getParticipantA().getName())
                            .replace("{name2}", match.getParticipantB().getName()), TournamentEvent.TYPE_MATCH_STARTED, tournament));
                    if (result == Result.AWINS){
                        match.getParticipantA().updateScore(1);
                        match.getParticipantB().updateScore(-1); 
                    }
                    else if (result == Result.BWINS){
                        match.getParticipantA().updateScore(-1);
                        match.getParticipantB().updateScore(1); 
                    }
                    tournament.notifyListeners(new TournamentEvent(Constants.MATCH_END.replace("{name1}", match.getParticipantA().getName())
                                .replace("{name2}", match.getParticipantB().getName()).replace("{matchResult}", result.toString()), TournamentEvent.TYPE_MATCH_STARTED, tournament));
                    match.setResult(result);
                    if (!tournament.areOtherThreadsAlive(this)){
                        tournament.notifyListeners(new TournamentEvent(tournament.getParticipants(), TournamentEvent.TYPE_TOURNAMENT_ENDED, tournament));
                    }
                }
            }
        };
    }
    
}
