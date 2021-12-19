package com.quilleash.arkhamlcg.metadata.model;

// Card with one or two faces
public class Card extends Item {
    private CardFace frontFace;
    private CardFace backFace;

    public CardFace getFrontFace() {
        return frontFace;
    }

    public void setFrontFace(CardFace frontFace) {
        this.frontFace = frontFace;
    }

    public CardFace getBackFace() {
        return backFace;
    }

    public void setBackFace(CardFace backFace) {
        this.backFace = backFace;
    }

    public Card swapFaces() {
        // copy the card
        Card card = copy();

        // swap faces
        CardFace back = card.getBackFace();
        card.setBackFace(card.getFrontFace());
        card.setFrontFace(back);
        return card;
    }

    public Card copy() {
        Card card = new Card();
        card.setName(getName());
        card.setSourcePath(getSourcePath());
        card.setFrontFace(getFrontFace().copy());
        card.setBackFace(getBackFace().copy());
        return card;
    }
}
