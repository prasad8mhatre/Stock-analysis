package com.market;

public class Trade {

    private String currentDepot;
    private String buyingDepot;
    private Float costOfProduct;
    private Float costOfDelivery;
    private Float totalCost;
    private String tradeType;

    public Trade() {
    }

    public Trade(String currentDepot, String buyingDepot, Float costOfProduct, Float costOfDelivery, Float totalCost) {
        this.currentDepot = currentDepot;
        this.buyingDepot = buyingDepot;
        this.costOfProduct = costOfProduct;
        this.costOfDelivery = costOfDelivery;
        this.totalCost = totalCost;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getCurrentDepot() {
        return currentDepot;
    }

    public void setCurrentDepot(String currentDepot) {
        this.currentDepot = currentDepot;
    }

    public String getBuyingDepot() {
        return buyingDepot;
    }

    public void setBuyingDepot(String buyingDepot) {
        this.buyingDepot = buyingDepot;
    }

    public Float getCostOfProduct() {
        return costOfProduct;
    }

    public void setCostOfProduct(Float costOfProduct) {
        this.costOfProduct = costOfProduct;
    }

    public Float getCostOfDelivery() {
        return costOfDelivery;
    }

    public void setCostOfDelivery(Float costOfDelivery) {
        this.costOfDelivery = costOfDelivery;
    }

    public Float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "currentDepot='" + currentDepot + '\'' +
                ", buyingDepot='" + buyingDepot + '\'' +
                ", costOfProduct=" + costOfProduct +
                ", costOfDelivery=" + costOfDelivery +
                ", totalCost=" + totalCost +
                '}';
    }
}
