package com.market;

import java.util.HashMap;
import java.util.Map;

public class DepotFactory {

    private String name;
    private int minOwnProductStock;
    private int maxOwnProductStock;
    private int minOtherProductStock;
    private int maxOtherProductStock;
    private int ownProductPrice;
    private int ownProductDeliveryPrice;
    private int depotAllowance;
    private Map<String, Integer> otherProducts = new HashMap<>();
    private int currentStock;

    public DepotFactory(String name, int minOwnProductStock, int maxOwnProductStock, int minOtherProductStock, int maxOtherProductStock,
                        int ownProductPrice, int ownProductDeliveryPrice, int depotAllowance, int currentStock) {
        this.name = name;
        this.minOwnProductStock = minOwnProductStock;
        this.maxOwnProductStock = maxOwnProductStock;
        this.minOtherProductStock = minOtherProductStock;
        this.maxOtherProductStock = maxOtherProductStock;
        this.ownProductPrice = ownProductPrice;
        this.ownProductDeliveryPrice = ownProductDeliveryPrice;
        this.depotAllowance = depotAllowance;
        this.currentStock = currentStock;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public void addOtherProduct(String productName, Integer count){
        otherProducts.put(productName, count);
    }

    public Map<String, Integer> getOtherProducts() {
        return otherProducts;
    }

    public void setOtherProducts(Map<String, Integer> otherProducts) {
        this.otherProducts = otherProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinOwnProductStock() {
        return minOwnProductStock;
    }

    public void setMinOwnProductStock(int minOwnProductStock) {
        this.minOwnProductStock = minOwnProductStock;
    }

    public int getMaxOwnProductStock() {
        return maxOwnProductStock;
    }

    public void setMaxOwnProductStock(int maxOwnProductStock) {
        this.maxOwnProductStock = maxOwnProductStock;
    }

    public int getMinOtherProductStock() {
        return minOtherProductStock;
    }

    public void setMinOtherProductStock(int minOtherProductStock) {
        this.minOtherProductStock = minOtherProductStock;
    }

    public int getMaxOtherProductStock() {
        return maxOtherProductStock;
    }

    public void setMaxOtherProductStock(int maxOtherProductStock) {
        this.maxOtherProductStock = maxOtherProductStock;
    }

    public int getOwnProductPrice() {
        return ownProductPrice;
    }

    public void setOwnProductPrice(int ownProductPrice) {
        this.ownProductPrice = ownProductPrice;
    }

    public int getOwnProductDeliveryPrice() {
        return ownProductDeliveryPrice;
    }

    public void setOwnProductDeliveryPrice(int ownProductDeliveryPrice) {
        this.ownProductDeliveryPrice = ownProductDeliveryPrice;
    }

    public int getDepotAllowance() {
        return depotAllowance;
    }

    public void setDepotAllowance(int depotAllowance) {
        this.depotAllowance = depotAllowance;
    }

    @Override
    public String toString() {
        return "DepotFactory{" +
                "name='" + name + '\'' +
                ", minOwnProductStock=" + minOwnProductStock +
                ", maxOwnProductStock=" + maxOwnProductStock +
                ", minOtherProductStock=" + minOtherProductStock +
                ", maxOtherProductStock=" + maxOtherProductStock +
                ", ownProductPrice=" + ownProductPrice +
                ", ownProductDeliveryPrice=" + ownProductDeliveryPrice +
                ", depotAllowance=" + depotAllowance +
                '}';
    }
}
