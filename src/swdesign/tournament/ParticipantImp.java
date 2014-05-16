/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swdesign.tournament;

import swdesign.game.AI;

/**
 *
 * @author adamv_000
 */
public class ParticipantImp<AIInstance> implements ParticipantInfo<AIInstance>, AI, Comparable {
    
    private int score;
    private AIInstance ai;

    public ParticipantImp(AIInstance ai) {
        this.ai = ai;
    }
    
    @Override
    public int getScore() {
        return score;
    }

    @Override
    public String getID() {
        return ((AI)ai).getID();
    }

    @Override
    public String getName() {
        return ((AI)ai).getName();
    }

    @Override
    public int compareTo(Object participant) {
        ParticipantImp p = (ParticipantImp)participant;
        
        if (p.getScore() > getScore()){
            return -1;
        }
        else if (p.getScore() < getScore()){
            return 1;
        }
        return 0;
    }  

    @Override
    public synchronized void updateScore(int score) {
        this.score += score;
    }

    @Override
    public AIInstance newInstance() {
        return ((AIInstance)((AI)ai).newInstance());
    }
}
