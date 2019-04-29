package com.market;

import com.market.utils.Utility;

import java.util.*;

public class Seeder {

    public List<Company> getCompanies(){
        List<Company> companies = new ArrayList<>();

        Company BigA = CompanyFactory.getCompany("BigA", "A", getDepots("BIGa"), "BigA");
        Company BigB = CompanyFactory.getCompany("BigB", "B", getDepots("BIGb"), "BigB");
        Company BigC = CompanyFactory.getCompany("BigC", "C", getDepots("BIGc"), "BigC");

        List<Company>  otherCompaniesForA = new ArrayList<>();
        otherCompaniesForA.add(BigB);
        otherCompaniesForA.add(BigC);

        BigA.setCompanies(otherCompaniesForA);

        List<Company>  otherCompaniesForB = new ArrayList<>();
        otherCompaniesForB.add(BigA);
        otherCompaniesForB.add(BigC);

        BigB.setCompanies(otherCompaniesForB);

        List<Company>  otherCompaniesForC = new ArrayList<>();
        otherCompaniesForC.add(BigA);
        otherCompaniesForC.add(BigB);

        BigC.setCompanies(otherCompaniesForC);

        companies.add(BigA);
        companies.add(BigB);
        companies.add(BigC);

        return companies;
    }


    private List<DepotFactory> getDepots(String companyName) {
        List<DepotFactory> depotList = new ArrayList<>();
        for(int i =0 ; i < 100 ; i++) {
            int ownProductPrice = Utility.getRandomNumber(1, 10);
            int ownDeliveryPrice = Utility.getRandomNumber(1, 10);
            int cashAllowance = Utility.getRandomNumber(50, 100);
            int currentStock = Utility.getRandomNumber(15, 50);
            String depotName = companyName + i;

            DepotFactory depotFactory = new DepotFactory(depotName,15, 50,  3,
                    40, ownProductPrice, ownDeliveryPrice, cashAllowance, currentStock);
            Map<String, Integer> otherProducts = new HashMap<>();
            if(companyName.equalsIgnoreCase("BigA")){
                otherProducts.put("C", Utility.getRandomNumber(3, 40));
                otherProducts.put("B", Utility.getRandomNumber(3, 40));
            }else if(companyName.equalsIgnoreCase("BigB")){
                otherProducts.put("C", Utility.getRandomNumber(3, 40));
                otherProducts.put("A", Utility.getRandomNumber(3, 40));
            }else{
                otherProducts.put("B", Utility.getRandomNumber(3, 40));
                otherProducts.put("A", Utility.getRandomNumber(3, 40));
            }
            depotFactory.setOtherProducts(otherProducts);
            depotList.add(depotFactory);
        }
        return depotList;
    }


}
