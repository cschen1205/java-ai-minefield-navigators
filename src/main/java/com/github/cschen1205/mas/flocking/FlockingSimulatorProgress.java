package com.github.cschen1205.mas.flocking;

import com.github.cschen1205.mas.flocking.flocks.GameWorld;

/**
 * Created by cschen1205 on 10/2/2015 0002.
 */
public class FlockingSimulatorProgress {
    private GameWorld gameWorld;
    private int trial;
    private int run;
    private int step;

    public FlockingSimulatorProgress(int run, int trial, int step, GameWorld gameWorld){
        this.run = run;
        this.trial = trial;
        this.step = step;
        this.gameWorld = gameWorld;
    }

    public GameWorld getGameWorld() {
        return gameWorld;
    }

    public int getTrial() {
        return trial;
    }

    public int getRun() {
        return run;
    }

    public int getStep() {
        return step;
    }
}
