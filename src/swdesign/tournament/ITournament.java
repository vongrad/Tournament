/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swdesign.tournament;

import swdesign.game.AI;
import swdesign.game.Game;

/**
 *
 * @author adamv_000
 */
public interface ITournament<AIInstance> {
    public void tournamentStart(Game game, AIInstance[] ai);
    public void matchStarted(int matchIndex);
    public void matchFinished(int matchIndex);
    public Game getGame();
    public ParticipantInfo[] getParticipants();
}
