package com.quilleash.arkhamlcg.metadata.model;

import java.util.ArrayList;
import java.util.List;

public class Location extends CardFace {
    private LocationSymbol locationSymbol;
    private List<LocationSymbol> connections = new ArrayList<>();
    private Integer shroud;
    private Integer clues;
    private boolean cluesPerInvestigator;

    public LocationSymbol getLocationSymbol() {
        return locationSymbol;
    }

    public void setLocationSymbol(LocationSymbol locationSymbol) {
        this.locationSymbol = locationSymbol;
    }

    public List<LocationSymbol> getConnections() {
        return connections;
    }

    public void setConnections(List<LocationSymbol> connections) {
        this.connections = connections;
    }

    public Integer getShroud() {
        return shroud;
    }

    public void setShroud(Integer shroud) {
        this.shroud = shroud;
    }

    public Integer getClues() {
        return clues;
    }

    public void setClues(Integer clues) {
        this.clues = clues;
    }

    public boolean isCluesPerInvestigator() {
        return cluesPerInvestigator;
    }

    public void setCluesPerInvestigator(boolean cluesPerInvestigator) {
        this.cluesPerInvestigator = cluesPerInvestigator;
    }

    @Override
    protected CardFace copy() {
        Location copy = new Location();
        copyInternal(copy);
        copy.setLocationSymbol(getLocationSymbol());
        copy.setConnections(new ArrayList<>(getConnections()));
        copy.setShroud(getShroud());
        copy.setClues(getClues());
        copy.setCluesPerInvestigator(isCluesPerInvestigator());
        return copy;
    }
}
