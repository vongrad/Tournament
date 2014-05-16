/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swdesign.builder;

import swdesign.tournament.Tournament;

/**
 *
 * @author adamv_000
 */
public interface IThreadBuilder {
    public Thread buildThread(Tournament tournament);
}
