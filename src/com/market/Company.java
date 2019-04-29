package com.market;

import java.util.List;

public abstract class Company {
    public abstract String  getProductName();
    public abstract List<Company> getTradingCompany();
    public abstract List<DepotFactory> getCompanyDepot();
    public abstract void setCompanies(List<Company> listCompanies);
    public abstract String getCompanyName();


    
}
