package com.market;

import java.util.ArrayList;
import java.util.List;

public class BillingManager {

    List<Trade> trades = new ArrayList<>();

    public List<Trade> getTrades() {
        return trades;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }

    public void addTraded(Trade trade){
        this.trades.add(trade);
    }

    public List<Trade> getTradingDetails(){
        return new ArrayList<>();
    }

    public void getUserTradedCompanyDetails(Company tradedCompany){

    }

    public void calculateProfitAndLoss(){

    }
}
