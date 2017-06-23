package com.github.cschen1205.mas.flocking;

import com.github.cschen1205.falcon.Falcon;
import com.github.cschen1205.falcon.FalconConfig;
import com.github.cschen1205.falcon.TDLambdaFalcon;
import com.github.cschen1205.mas.flocking.agents.FalconBoidAgent;
import com.github.cschen1205.mas.flocking.agents.TDFalconBoidAgent;

/**
 * Created by cschen1205 on 10/1/2015 0001.
 */
public class FlockingSimulatorQLambda extends FlockingSimulator {

    public FlockingSimulatorQLambda(FlockingSimulatorConfig config, FalconConfig falconConfig){
        super(config, falconConfig);
    }

    @Override
    protected Falcon createBrain(){
        return new TDLambdaFalcon(falconConfig);
    }

    @Override
    protected FalconBoidAgent createAgent(int agentId, Falcon brain){
        int numSonarInput = config.numSonarInput;
        int numAVSonarInput = config.numAVSonarInput;
        int numBearingInput = config.numBearingInput;
        int numRangeInput = config.numRangeInput;

        TDFalconBoidAgent newAgent = new TDFalconBoidAgent((TDLambdaFalcon)brain, falconConfig, agentId, numSonarInput, numAVSonarInput, numBearingInput, numRangeInput);
        newAgent.useImmediateRewardAsQ = false;

        if(config.isImmediateRewardProvided()){
            newAgent.setQGamma(0.5);
        } else {
            newAgent.setQGamma(0.9);
        }

        return newAgent;
    }

    public static void main(String[] args){
        FlockingSimulatorConfig config = new FlockingSimulatorConfig();
        config.setImmediateRewardProvided(false);
        config.setName("flocking-q-lambda");

        FalconConfig falconConfig = new FalconConfig();
        falconConfig.numAction = FalconBoidAgent.numAction;
        falconConfig.numState = config.numState();
        falconConfig.numReward = 2;

        FlockingSimulatorQLambda simulator = new FlockingSimulatorQLambda(config, falconConfig);
        simulator.runSims();
    }
}
