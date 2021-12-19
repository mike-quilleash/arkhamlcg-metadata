package com.quilleash.arkhamlcg.metadata.model;

public class Enemy extends CardFace {
    @Override
    protected CardFace copy() {
        Enemy copy = new Enemy();
        copyInternal(copy);
        return copy;
    }
}
