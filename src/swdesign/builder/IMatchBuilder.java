/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swdesign.builder;

import swdesign.tournament.MatchInfo;
import swdesign.tournament.ParticipantInfo;

/**
 *
 * @author adamv_000
 */
public interface IMatchBuilder {
    
    public MatchInfo[] buildMatches(ParticipantInfo[] participants);
    public int calculateSize(int n, int r);
}
