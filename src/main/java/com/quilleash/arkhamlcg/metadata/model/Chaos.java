package com.quilleash.arkhamlcg.metadata.model;

public class Chaos extends CardFace {
    @Override
    protected CardFace copy() {
        Chaos copy = new Chaos();
        copyInternal(copy);
        return copy;
    }
}
