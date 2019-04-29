package com.market;

import java.util.List;

public class CompanyFactory {

    public static Company getCompany(String type, String productName, List<DepotFactory> companyDepots, String companyName) {
        if("BigA".equalsIgnoreCase(type)) {
            return new BigA(productName, companyDepots, companyName);
        } else if ("BigB".equalsIgnoreCase(type)) {
            return new BigB(productName, companyDepots, companyName);
        } else if ("BigC".equalsIgnoreCase(type)) {
            return new BigC(productName, companyDepots, companyName);
        }
        return null;
    }
}
