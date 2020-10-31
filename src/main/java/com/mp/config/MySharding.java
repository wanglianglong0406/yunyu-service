package com.mp.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

public class MySharding implements PreciseShardingAlgorithm<String> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        String id = preciseShardingValue.getValue();
        int mode=id.hashCode()% collection.size();
        String[] strings = collection.toArray(new String[0]);
        mode=Math.abs(mode);
        System.err.println(strings[0]+"--------------"+strings[1]);
        System.err.println("--------mode------"+mode);
        return strings[mode];
    }
}
