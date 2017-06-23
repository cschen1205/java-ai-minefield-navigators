package com.github.cschen1205.mas.flocking;

import com.github.cschen1205.falcon.Falcon;
import com.github.cschen1205.falcon.FalconConfig;
import com.github.cschen1205.falcon.RFalcon;
import com.github.cschen1205.mas.flocking.agents.FalconBoidAgent;
import com.github.cschen1205.mas.flocking.agents.RFalconBoidAgent;

/**
 * Created by cschen1205 on 10/1/2015 0001.
 */
public class FlockingSimulatorR extends FlockingSimulator {

    @Override
    protected Falcon createBrain(){
        return new RFalcon(falconConfig);
    }

    @Override
    protected FalconBoidAgent createAgent(int agentId, Falcon brain){
        int numSonarInput = config.numSonarInput;
        int numAVSonarInput = config.numAVSonarInput;
        int numBearingInput = config.numBearingInput;
        int numRangeInput = config.numRangeInput;

        return new RFalconBoidAgent((RFalcon)brain, falconConfig, agentId, numSonarInput, numAVSonarInput, numBearingInput, numRangeInput);
    }

    public FlockingSimulatorR(FlockingSimulatorConfig config, FalconConfig falconConfig){
        super(config, falconConfig);
    }

    public static void main(String[] args){
        FlockingSimulatorConfig config = new FlockingSimulatorConfig();
        config.setImmediateRewardProvided(true);
        config.setName("flocking-r");

        FalconConfig falconConfig = new FalconConfig();
        falconConfig.numAction = FalconBoidAgent.numAction;
        falconConfig.numState = config.numState();
        falconConfig.numReward = 2;

        FlockingSimulatorR simulator = new FlockingSimulatorR(config, falconConfig);
        simulator.runSims();
    }
}
