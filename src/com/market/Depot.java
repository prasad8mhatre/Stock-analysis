package com.market;

public abstract  class Depot {

    public abstract String getDepotName();
    public abstract int getMinOwnProductStock();
    public abstract int getMaxOwnProductStock();
    public abstract int getMinOtherProductStock();
    public abstract int getMaxOtherProductStock();
    public abstract int getOwnProductPrice();
    public abstract int getOwnProductDeliveryPrice();


}
