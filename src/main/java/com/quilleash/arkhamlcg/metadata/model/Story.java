package com.quilleash.arkhamlcg.metadata.model;

public class Story extends CardFace {
    @Override
    protected CardFace copy() {
        Story copy = new Story();
        copyInternal(copy);
        return copy;
    }
}
