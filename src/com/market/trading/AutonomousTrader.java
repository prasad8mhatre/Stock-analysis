package com.market.trading;

import com.market.Company;

public class AutonomousTrader implements Trader {
    Company tradingCompany;

    public AutonomousTrader(Company tradingCompany) {
        this.tradingCompany = tradingCompany;
    }

    @Override
    public void buy() {

    }

    @Override
    public void sell() {

    }
}
