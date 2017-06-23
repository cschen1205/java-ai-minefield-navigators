package com.github.cschen1205.mas.flocking;

import com.github.cschen1205.falcon.FalconConfig;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by memeanalytics on 23/6/17.
 */
public class FlockingSimulatorUnitTest {

    private FlockingSimulator createSimulator(String falconMode, FlockingSimulatorConfig simConfig, FalconConfig aiConfig){
        int numSims = simConfig.getNumRuns();
        int startSim = simConfig.getStartRun();

        String name="minefield-flocking";




        System.out.println("Start: " + startSim + "\tNo. of runs: "+numSims);
        simConfig.setName(name);


        if(falconMode.equalsIgnoreCase("sarsa")) {
            return new FlockingSimulatorSarsa(simConfig, aiConfig);
        } else if(falconMode.equalsIgnoreCase("qlearn")) {
            return new FlockingSimulatorQ(simConfig, aiConfig);
        } else if(falconMode.equalsIgnoreCase("sarsalambda")) {
            return new FlockingSimulatorSarsaLambda(simConfig, aiConfig);
        } else if(falconMode.equalsIgnoreCase("r")) {
            return new FlockingSimulatorR(simConfig, aiConfig);
        } else {
            return new FlockingSimulatorQLambda(simConfig, aiConfig);
        }
    }

    @Test
    public void test(){
        FlockingSimulatorConfig config = new FlockingSimulatorConfig();
        config.setImmediateRewardProvided(false);
        config.setNumRuns(1);
        config.setMaxTrial(300);


        FalconConfig falconConfig = new FalconConfig();
        falconConfig.numAction = 5;
        falconConfig.numState = config.numState();
        falconConfig.numReward = 2;
        falconConfig.isBounded = false;

        String falconMode = "qlearn";


        FlockingSimulator simulator = createSimulator(falconMode, config, falconConfig);
        simulator.runSims();
    }
}