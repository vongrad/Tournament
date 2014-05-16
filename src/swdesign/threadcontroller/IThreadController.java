/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swdesign.threadcontroller;

import swdesign.tournament.MatchInfo;

/**
 *
 * @author adamv_000
 */
public interface IThreadController {

    public MatchInfo getNextMatch();
    public boolean areOtherThreadsAlive(Thread thread);
}
