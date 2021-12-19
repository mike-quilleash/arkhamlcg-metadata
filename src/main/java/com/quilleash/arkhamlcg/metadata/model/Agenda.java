package com.quilleash.arkhamlcg.metadata.model;

public class Agenda extends CardFace {
    private int index;
    private char deckId;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public char getDeckId() {
        return deckId;
    }

    public void setDeckId(char deckId) {
        this.deckId = deckId;
    }

    @Override
    protected CardFace copy() {
        Act copy = new Act();
        copyInternal(copy);
        copy.setDeckId(getDeckId());
        copy.setIndex(getIndex());
        return copy;
    }
}
