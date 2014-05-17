/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swdesign.builder;

import swdesign.tournament.MatchInfoImp;
import swdesign.tournament.MatchInfo;
import swdesign.tournament.ParticipantInfo;

/**
 *
 * @author adamv_000
 */
public class MatchBuilderImp implements IMatchBuilder{

    @Override
    public MatchInfo[] buildMatches(ParticipantInfo[] participants) {
        
        MatchInfo[] matches = new MatchInfo[calculateSize(participants.length, 2)];

        int index = 0;
        
        for (int i = 0; i < participants.length; i++) {
            for (int j = i + 1; j < participants.length; j++) {
                matches[index++] = new MatchInfoImp(participants[i], participants[j]);
            }
        }
        
        return matches;
    }

    @Override
    public int calculateSize(int n, int r) {
        return factorial(n) / ((factorial(n - r)) * factorial(r));
    }
    
    public int factorial(int n){
        return n == 1 ? 1 : factorial(n - 1) * n;
    } 
}
