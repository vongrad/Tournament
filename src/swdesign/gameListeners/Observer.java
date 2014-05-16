/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swdesign.gameListeners;

/**
 *
 * @author adamv_000
 */
public interface Observer {
    public void addListener(ITournamentListener listener);
    public void removeListener(ITournamentListener listener);
    public void notifyListeners(TournamentEvent event);
}
