package com.quilleash.arkhamlcg.metadata.model;

public class EncounterCardBack extends CardFace {
    @Override
    protected CardFace copy() {
        // no state in placeholder card back faces
        return this;
    }
}
