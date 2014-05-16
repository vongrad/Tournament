/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swdesign.tournament;

import java.util.ArrayList;
import java.util.List;
import swdesign.builder.IMatchBuilder;
import swdesign.builder.IParticipantBuilder;
import swdesign.builder.IThreadBuilder;
import swdesign.builder.MatchBuilderImp;
import swdesign.builder.ParticipantBuilderImp;
import swdesign.builder.ThreadBuilderImp;
import swdesign.game.AI;
import swdesign.game.Game;
import swdesign.gameListeners.Constants;
import swdesign.gameListeners.ITournamentListener;
import swdesign.gameListeners.Observer;
import swdesign.gameListeners.TournamentEvent;
import swdesign.threadcontroller.IThreadController;

/**
 *
 * @author adamv_000
 */
public class Tournament<AIInstance> implements ITournament<AIInstance>, IThreadController, Observer {

    private int matchIndex;
    private ParticipantInfo<AIInstance>[] participants;
    private MatchInfo[] matches;
    private Thread[] threads;
    private Game game;

    private boolean notificationSent;

    private List<ITournamentListener> listeners;

    private IMatchBuilder matchBuilder;
    private IParticipantBuilder participantBuilder;
    private IThreadBuilder threadBuilder;

    public Tournament(int numberOfThreads) {
        listeners = new ArrayList<>();
        matchBuilder = new MatchBuilderImp();
        threadBuilder = new ThreadBuilderImp();
        participantBuilder = new ParticipantBuilderImp();
        threads = new Thread[numberOfThreads];
        notificationSent = false;
    }

    @Override
    public void tournamentStart(Game game, AIInstance[] ai) {
        this.game = game;
        participants = participantBuilder.buildParticipants(ai);
        matches = matchBuilder.buildMatches(participants);
        matchIndex = 0;
        notifyListeners(new TournamentEvent(Constants.TOURNAMENT_START, TournamentEvent.TYPE_TOURNAMENT_STARTED, this));
        initializeThreads();
        executeThreads();
    }

    @Override
    public void matchStarted(int matchIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void matchFinished(int matchIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void initializeThreads() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = threadBuilder.buildThread(this);
        }
    }

    private void executeThreads() {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    @Override
    public synchronized MatchInfo getNextMatch() {
        if (matchIndex < matches.length) {
            return matches[matchIndex++];
        }
        if (!notificationSent) {
            notificationSent = true;

        }
        return null;
    }

    @Override
    public Game getGame() {
        return this.game;
    }

    @Override
    public void addListener(ITournamentListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(ITournamentListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void notifyListeners(TournamentEvent event) {
        for (ITournamentListener listener : listeners) {
            listener.gameUpdate(event);
        }
    }

    @Override
    public boolean areOtherThreadsAlive(Thread currentThread) {
        for (Thread thread : threads) {
            if (thread.isAlive() && thread != currentThread) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ParticipantInfo[] getParticipants() {
        return participants;
    }
}
