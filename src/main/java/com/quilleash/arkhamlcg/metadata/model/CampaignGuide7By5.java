package com.quilleash.arkhamlcg.metadata.model;

public class CampaignGuide7By5 extends CardFace {
    private int pageNumber;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    protected CardFace copy() {
        CampaignGuide7By5 copy = new CampaignGuide7By5();
        copyInternal(copy);
        return copy;
    }
}
