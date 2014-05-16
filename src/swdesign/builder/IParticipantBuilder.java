/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swdesign.builder;

import swdesign.game.AI;
import swdesign.tournament.ParticipantInfo;

/**
 *
 * @author adamv_000
 */
public interface IParticipantBuilder<AIInstance> {
   
    public ParticipantInfo<AIInstance>[] buildParticipants(AIInstance[] ai);
}
