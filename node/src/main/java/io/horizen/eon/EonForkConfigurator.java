package io.horizen.eon;

import io.horizen.account.fork.GasFeeFork;
import io.horizen.fork.ForkConfigurator;
import io.horizen.fork.OptionalSidechainFork;
import io.horizen.fork.SidechainForkConsensusEpoch;
import io.horizen.utils.Pair;

import java.math.BigInteger;
import java.util.List;

public class EonForkConfigurator extends ForkConfigurator {
    @Override
    public SidechainForkConsensusEpoch fork1activation() {
        return new SidechainForkConsensusEpoch(0, 0, 0);
    }

    @Override
    public List<Pair<SidechainForkConsensusEpoch, OptionalSidechainFork>> getOptionalSidechainForks() {
        return List.of(
                new Pair<>(
                        // TODO: testnet activation TBD
                        new SidechainForkConsensusEpoch(0, 0, 0),
                        new GasFeeFork(
                                // block gas limit: 10 million
                                BigInteger.valueOf(10000000),
                                BigInteger.valueOf(2),
                                BigInteger.valueOf(8),
                                // minimum base fee: 20 Gwei (20*10^9)
                                BigInteger.valueOf(20000000000L)
                        )
                )
        );
    }
}
