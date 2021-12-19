package com.quilleash.arkhamlcg.metadata.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Location.class),
        @JsonSubTypes.Type(value = Asset.class),
        @JsonSubTypes.Type(value = StoryAsset.class),
        @JsonSubTypes.Type(value = Chaos.class),
        @JsonSubTypes.Type(value = Story.class),
        @JsonSubTypes.Type(value = Scenario.class),
        @JsonSubTypes.Type(value = WeaknessTreachery.class),
        @JsonSubTypes.Type(value = CampaignGuide7By5.class),
        @JsonSubTypes.Type(value = Treachery.class),
        @JsonSubTypes.Type(value = Enemy.class),
        @JsonSubTypes.Type(value = Agenda.class),
        @JsonSubTypes.Type(value = Act.class),
        @JsonSubTypes.Type(value = PlayerCardBack.class),
        @JsonSubTypes.Type(value = EncounterCardBack.class)
})
public abstract class CardFace {
    private String title;
    private List<String> traits = new ArrayList<>();
    private String encounterSetNumber;
    private Integer encounterSetTotal;
    private String fullPathToImage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTraits() {
        return traits;
    }

    public void setTraits(List<String> traits) {
        this.traits = traits;
    }

    public String getEncounterSetNumber() {
        return encounterSetNumber;
    }

    public void setEncounterSetNumber(String encounterSetNumber) {
        this.encounterSetNumber = encounterSetNumber;
    }

    public Integer getEncounterSetTotal() {
        return encounterSetTotal;
    }

    public void setEncounterSetTotal(Integer encounterSetTotal) {
        this.encounterSetTotal = encounterSetTotal;
    }

    public String getFullPathToImage() {
        return fullPathToImage;
    }

    public void setFullPathToImage(String fullPathToImage) {
        this.fullPathToImage = fullPathToImage;
    }

    @Override
    public String toString() {
        return getTitle();
    }

    protected abstract CardFace copy();

    protected void copyInternal(CardFace copy) {
        copy.setTitle(getTitle());
        copy.setTraits(new ArrayList<>(getTraits()));
        copy.setEncounterSetNumber(getEncounterSetNumber());
        copy.setEncounterSetTotal(getEncounterSetTotal());
        copy.setFullPathToImage(getFullPathToImage());
    }
}
