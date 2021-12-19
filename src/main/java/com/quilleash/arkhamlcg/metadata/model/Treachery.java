package com.quilleash.arkhamlcg.metadata.model;

public class Treachery extends CardFace {
    @Override
    protected CardFace copy() {
        Treachery copy = new Treachery();
        copyInternal(copy);
        return copy;
    }
}
