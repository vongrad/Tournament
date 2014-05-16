/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swdesign.builder;

import swdesign.game.AI;
import swdesign.tournament.ParticipantImp;
import swdesign.tournament.ParticipantInfo;

/**
 *
 * @author adamv_000
 */
public class ParticipantBuilderImp<AIInstance> implements IParticipantBuilder<AIInstance>{

    @Override
    public ParticipantInfo<AIInstance>[] buildParticipants(AIInstance[] ai) {
        
        ParticipantInfo[] participants = new ParticipantImp[ai.length];
        
        for (int i = 0; i < ai.length; i++) {
            participants[i] = new ParticipantImp<AIInstance>(ai[i]);
        }
        return participants;
    }

   
    
}
