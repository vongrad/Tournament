/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swdesign.gameListeners;

import java.util.EventObject;
import swdesign.tournament.ParticipantInfo;

/**
 *
 * @author adamv_000
 */
public class TournamentEvent extends EventObject {

    public static final int TYPE_TOURNAMENT_STARTED = 1;
    public static final int TYPE_TOURNAMENT_ENDED = 2;
    public static final int TYPE_MATCH_STARTED = 3;
    public static final int TYPE_MATCH_ENDED = 4;
    public static final int TYPE_WIN_A = 5;
    public static final int TYPE_WIN_B = 6;
    public static final int TYPE_TIE = 7;

    private String message;
    ParticipantInfo[] participants;

    private int type;

    public TournamentEvent(Object source) {
        super(source);
    }

    public TournamentEvent(String message, int type, Object source) {
        super(source);
        this.type = type;
        this.message = message;
    }

    public TournamentEvent(ParticipantInfo[] participants, int type, Object source) {
        super(source);
        this.type = type;
        this.participants = participants;
    }

    public String getMessage() {
        return message;
    }

    public int getType() {
        return type;
    }

    public ParticipantInfo[] getParticipants() {
        return participants;
    }

}
