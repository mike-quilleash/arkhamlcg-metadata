package com.quilleash.arkhamlcg.metadata.model;

public class Asset extends CardFace {
    @Override
    protected CardFace copy() {
        Asset copy = new Asset();
        copyInternal(copy);
        return copy;
    }
}
