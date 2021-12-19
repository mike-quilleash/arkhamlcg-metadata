package com.quilleash.arkhamlcg.metadata.model;

public class Scenario extends CardFace {
    @Override
    protected CardFace copy() {
        Scenario copy = new Scenario();
        copyInternal(copy);
        return copy;
    }
}
