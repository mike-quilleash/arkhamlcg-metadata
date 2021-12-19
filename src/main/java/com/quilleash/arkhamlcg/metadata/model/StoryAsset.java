package com.quilleash.arkhamlcg.metadata.model;

public class StoryAsset extends CardFace {
    @Override
    protected CardFace copy() {
        StoryAsset copy = new StoryAsset();
        copyInternal(copy);
        return copy;
    }
}
