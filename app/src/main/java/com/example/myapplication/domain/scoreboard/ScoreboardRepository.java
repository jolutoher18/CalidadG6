package com.example.myapplication.domain.scoreboard;

/**
 * A {@link ScoreboardRepository} that represents the scoreboard storage.
 */
public interface ScoreboardRepository {

    /**
     * @return the current active {@link Scoreboard}
     */
    Scoreboard findScoreboard();

    /**
     * Stores the given scoreboard.
     * @param scoreboard the scoreboard to be stored
     * @return the stored scoreboard
     */
    Scoreboard saveScoreboard(Scoreboard scoreboard);

}
