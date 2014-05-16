/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swdesign.tournament;

import swdesign.game.GameInstance;
import swdesign.game.GameInstance.Result;

/**
 *
 * @author adamv_000
 */
public class MatchInfoImp implements MatchInfo{
    
    private long matchId;
    private ParticipantInfo participantA;
    private ParticipantInfo participantB;
    
    private boolean hasFinished;
    private Result result;

    public MatchInfoImp(ParticipantInfo participantA, ParticipantInfo participantB) {
        matchId = System.nanoTime();
        this.participantA = participantA;
        this.participantB = participantB;
    }
    
    @Override
    public long matchID() {
        return matchId;
    }

    @Override
    public ParticipantInfo getParticipantA() {
        return this.participantA;
    }

    @Override
    public ParticipantInfo getParticipantB() {
        return this.participantB;
    }

    @Override
    public boolean hasFinished() {
        return hasFinished;
    }

    @Override
    public GameInstance.Result getResult() {
        return result;
    }

    @Override
    public void setResult(Result result) {
        this.result = result;
    }
    
}
