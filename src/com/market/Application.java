package com.market;

import com.market.trading.AutonomousTrader;
import com.market.trading.ManualTrader;
import com.market.trading.Trader;
import com.market.utils.Utility;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        List<Company> companyList = new ArrayList<>();
        Seeder  seeder = new Seeder();
        companyList = seeder.getCompanies();
        Scanner sc = new Scanner(System.in);
        BillingManager billingManager = new BillingManager();
        System.out.println("**********************************************************************************");
        System.out.println("------------------------------- Stock Analysis------------------------------------");
        System.out.println("**********************************************************************************");
        while(true){
            System.out.println("What do you want to do?");
            System.out.println("1. Trading");
            System.out.println("2. Report");
            System.out.println("3. Exit");
            System.out.println("Enter your Choice:");
            int choice = sc.nextInt();
            if(choice == 1){
                trading(companyList, sc, billingManager);
            }
            if(choice == 2){
                reporting(billingManager, companyList);
            }
            if(choice == 3){
                System.exit(0);
            }
        }
    }

    private static void reporting(BillingManager billingManager, List<Company> companyList) {
        System.out.println("All trades");
        System.out.println("-----------------------------------------");
        printAllTrades(billingManager);

        System.out.println("All Company Status");
        System.out.println("-----------------------------------------");
        printCompanyTrades(companyList, billingManager);

        System.out.println("Profit and Loss");
        System.out.println("-----------------------------------------");
        profitAndLoss(companyList, billingManager);
    }

    private static void profitAndLoss(List<Company> companyList, BillingManager billingManager) {
        Map<String, Integer> buyList = new HashMap<>();
        Map<String, Integer> sellList = new HashMap<>();

        for (Trade trade: billingManager.getTrades()) {
            if(trade.getTradeType().equalsIgnoreCase("SELL")){
                if(sellList.containsKey(trade.getBuyingDepot())){
                    sellList.put(trade.getBuyingDepot(), sellList.get(trade.getBuyingDepot()) + 1);
                }else {
                    sellList.put(trade.getBuyingDepot(), 0);
                }
            }else{
                if(buyList.containsKey(trade.getBuyingDepot())){
                    buyList.put(trade.getBuyingDepot(), buyList.get(trade.getBuyingDepot()) + 1 );
                }else{
                    buyList.put(trade.getBuyingDepot(), 0);
                }
            }
        }

        String companyName = new String();
        Integer maxSellValue = new Integer(0);
        for (Map.Entry<String,Integer> entry : sellList.entrySet()){
            if(entry.getValue() >= maxSellValue){
                companyName = entry.getKey();
                maxSellValue = entry.getValue();
            }
        }

        System.out.println("Company that spent the most: " + companyName);



        String spentCompanyName = new String();
        Integer maxSpentValue = new Integer(0);
        for (Map.Entry<String,Integer> entry : buyList.entrySet()){
            if(entry.getValue() >= maxSpentValue){
                spentCompanyName = entry.getKey();
                maxSpentValue = entry.getValue();
            }
        }

        System.out.println("company that made the most: " + spentCompanyName);
    }

    private static void printAllTrades(BillingManager billingManager){
        System.out.println("Current Depot | Buying Depot | Cost Of product | Cost of Delivery | Total Cost | Trade Type");
        for (Trade trade:billingManager.getTrades()) {
            System.out.println(trade.getCurrentDepot() + " | " + trade.getBuyingDepot() +
                    " | " + trade.getCostOfProduct() + " | " + trade.getCostOfDelivery() + " | " + trade.getTotalCost() + " | " + trade.getTradeType());
        }
    }

    private static void printCompanyTrades(List<Company> companyList, BillingManager billingManager){
        System.out.println("Company | Total Trade");
        Map<String, Float> trades = new HashMap<>();
        for (Trade trade: billingManager.getTrades()) {
            if(trades.containsKey(trade.getBuyingDepot())){
                trade.setCostOfProduct(trade.getTotalCost() + trades.get(trade.getBuyingDepot()));
            }
            trades.put(trade.getBuyingDepot(), trade.getTotalCost());
        }
        for (Map.Entry<String,Float> entry : trades.entrySet()){
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }

        System.out.println("Detailed information on user company that traded:");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Current Depot | Buying Depot | Cost Of product | Cost of Delivery | Total Cost");
        for (Trade trade:billingManager.getTrades()) {
            System.out.println(trade.getCurrentDepot() + " | " + trade.getBuyingDepot() +
                    " | " + trade.getCostOfProduct() + " | " + trade.getCostOfDelivery() + " | " + trade.getTotalCost());
        }
    }

    private static void trading(List<Company> companyList, Scanner sc, BillingManager billingManager) {
        while(true){
            System.out.println("Enter your company:");
            System.out.println("1. BigA");
            System.out.println("2. BigB");
            System.out.println("3. BigC");
            System.out.println("4. Back");
            System.out.println("Enter your Choice:");
            int companyChoice = sc.nextInt();
            if(companyChoice == 4){
                break;
            }
            Company tradingCompany = companyList.get(companyChoice-1);
            System.out.println("Trading Company: " + tradingCompany.getCompanyName());

            System.out.println("Select Mode of Trading:");
            System.out.println("1. Manual");
            System.out.println("2. Autonomous");
            System.out.println("Enter your Choice:");

            int tradingChoice = sc.nextInt();



            if(tradingChoice == 1){
                manualTrading(billingManager, tradingCompany, companyList);
            }else if(tradingChoice == 2){
                autonomousTrading(billingManager, tradingCompany, companyList);
            }else{
                System.out.println("Invalid input!");
            }
        }
    }

    private static void manualTrading(BillingManager billingManager, Company tradingCompany, List<Company> companyList){
        Trader trader = new ManualTrader(tradingCompany);
        Trade trade = new Trade();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter depot from 1...100");
        int fromDepotChoice = sc.nextInt();
        if(fromDepotChoice <= 100 && fromDepotChoice >= 0){
            trade.setCurrentDepot(tradingCompany.getCompanyName() + fromDepotChoice);
        }

        System.out.println("Enter company with whom you want to trade:");
        System.out.println("1. BigA");
        System.out.println("2. BigB");
        System.out.println("3. BigC");
        System.out.println("4. Back");
        System.out.println("Enter your Choice:");
        int companyChoice = sc.nextInt();



        System.out.println("Enter depot to 1...100");
        int toDepotChoice = sc.nextInt();
        Company toCompany = companyList.get(companyChoice-1);


        if(toDepotChoice <= 100 && toDepotChoice >= 0){
            trade.setBuyingDepot(toCompany.getCompanyName() + toDepotChoice);
        }

        System.out.println("Stock price of your product depot");
        System.out.println("Product Stock:" + tradingCompany.getCompanyDepot().get(fromDepotChoice).getCurrentStock());
        System.out.println("Stock of other company:" + tradingCompany.getCompanyDepot().get(fromDepotChoice).getOtherProducts().get(toCompany.getProductName()));


        System.out.println("Enter your trade:");
        System.out.println("1. Sell");
        System.out.println("2. Buy");
        System.out.println("Enter your Choice:");
        int tradeAction = sc.nextInt();

        System.out.println("Enter your Quantity:");
        int tradeQuantity = sc.nextInt();

        System.out.println("Enter your Price  (50 - 100):");
        int tradePrice = sc.nextInt();

        executeTrade(toCompany, tradingCompany, fromDepotChoice, tradeAction, tradeQuantity,tradePrice,trade,billingManager);



    }

    private static void executeTrade(Company toCompany , Company tradingCompany, int fromDepotChoice, int tradeAction ,
                              int tradeQuantity,int tradePrice , Trade trade, BillingManager billingManager ){
        String productName = toCompany.getProductName();
        DepotFactory currentDepot = tradingCompany.getCompanyDepot().get(fromDepotChoice);
        Integer currentStockOfOtherProduct = currentDepot.getOtherProducts().get(productName);
        System.out.println("currentStockOfOtherProduct: " + currentStockOfOtherProduct);
        if(tradePrice < 50 || tradePrice > 100){
            System.out.println("Trade cannot be done, as tradeprice is out of range");
        }else{
            int currentStock  = tradingCompany.getCompanyDepot().get(fromDepotChoice).getCurrentStock();
            if(tradeAction == 1){
                trade.setTradeType("SELL");
                tradingCompany.getCompanyDepot().get(fromDepotChoice).setCurrentStock(currentStock - tradeQuantity);
            }else{
                trade.setTradeType("BUY");
                tradingCompany.getCompanyDepot().get(fromDepotChoice).setCurrentStock(currentStock + tradeQuantity);
            }
            trade.setCostOfProduct(new Float(tradePrice));
            trade.setCostOfDelivery(new Float(currentDepot.getOwnProductDeliveryPrice()));
            trade.setTotalCost(new Float(tradePrice * tradeQuantity));
            billingManager.addTraded(trade);
            System.out.println("Trade executed successfully!");
        }
    }

    private static void autonomousTrading(BillingManager billingManager, Company tradingCompany, List<Company> companyList){
        Trader trader = new AutonomousTrader(tradingCompany);
        Trade trade = new Trade();

        int fromDepotChoice = Utility.getRandomNumber(1,100);
        trade.setCurrentDepot(tradingCompany.getCompanyName() + fromDepotChoice);


        int toDepotChoice = Utility.getRandomNumber(1,100);
        Company toCompany;
        if(tradingCompany.getCompanyName() == "BigA"){
            toCompany = companyList.get(Utility.getRandomNumber(1,2));
        }else if(tradingCompany.getCompanyName() == "BigB"){
            toCompany = companyList.get(2);
        }else{
            toCompany = companyList.get(Utility.getRandomNumber(0,1));
        }

        trade.setBuyingDepot(toCompany.getCompanyName() + toDepotChoice);

        int tradeAction = Utility.getRandomNumber(1,3);

        int tradeQuantity = Utility.getRandomNumber(3,40);

        int tradePrice = Utility.getRandomNumber(50,100);

        executeTrade(toCompany, tradingCompany, fromDepotChoice, tradeAction, tradeQuantity,tradePrice,trade,billingManager);


    }


}
