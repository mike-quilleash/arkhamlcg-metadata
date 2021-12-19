package com.quilleash.arkhamlcg.metadata.model;

public class WeaknessTreachery extends CardFace {
    @Override
    protected CardFace copy() {
        WeaknessTreachery copy = new WeaknessTreachery();
        copyInternal(copy);
        return copy;
    }
}
