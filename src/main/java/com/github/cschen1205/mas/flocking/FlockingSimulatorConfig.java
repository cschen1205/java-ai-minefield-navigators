package com.github.cschen1205.mas.flocking;

import com.github.cschen1205.mas.utils.SimulatorConfig;

/**
 * Created by cschen1205 on 10/1/2015 0001.
 */
public class FlockingSimulatorConfig extends SimulatorConfig {

    private int mineFieldSize = 32; // size of the mine field
    private int numMines = 10; // the number of mines created in the mine field per trial

    private int maxStep = 60; // the maximum number of steps in a trial before the autonomous vehicle is stopped

    private boolean immediateRewardProvided = false; // whether immediate reward is provided in a trial
    private int uiInterval = 100; // interval for each step in ui thread

    public boolean flocking = true;

    public boolean targetMoving = false;

    public int numSonarInput = 10;
    public int numAVSonarInput = 10;
    public int numBearingInput = 8;
    public int numRangeInput = 0;

    public boolean singleAI = false;

    public int getNumAI() {
        if (singleAI) return 1;
        return getNumAgents();
    }

    public int numState() {
        return numSonarInput + numAVSonarInput + numBearingInput + numRangeInput;
    }

    public int getUiInterval() {
        return uiInterval;
    }

    public void setUiInterval(int interval) {
        uiInterval = interval;
    }

    public int getMineFieldSize() {
        return mineFieldSize;
    }

    public void setMineFieldSize(int mineFieldSize) {
        this.mineFieldSize = mineFieldSize;
    }

    public int getNumMines() {
        return numMines;
    }

    public void setNumMines(int numMines) {
        this.numMines = numMines;
    }

    public boolean isImmediateRewardProvided() {
        return immediateRewardProvided;
    }

    public void setImmediateRewardProvided(boolean provided) {
        immediateRewardProvided = provided;
    }




    public int getMaxStep() {
        return maxStep;
    }

    public void setMaxStep(int maxStep) {
        this.maxStep = maxStep;
    }
}
