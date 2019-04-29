package com.market;

import java.util.List;

public class BigA extends  Company {

    private String productName;
    private List<Company> companies;
    private List<DepotFactory> companyDepots;
    private String companyName;

    public BigA(String productName, List<DepotFactory> companyDepots, String companyName) {
        this.productName = productName;
        this.companyDepots = companyDepots;
        this.companyName = companyName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String getProductName() {
        return this.productName;
    }

    @Override
    public List<Company> getTradingCompany() {
        return this.companies;
    }

    @Override
    public List<DepotFactory> getCompanyDepot() {
        return this.companyDepots;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return "BigA{" +
                "productName='" + productName + '\'' +
                '}';
    }
}
