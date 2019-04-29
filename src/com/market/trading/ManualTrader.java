package com.market.trading;

import com.market.Company;

public class ManualTrader implements Trader {

    Company tradingCompany;

    public ManualTrader(Company tradingCompany) {
        this.tradingCompany = tradingCompany;
    }

    @Override
    public void buy() {

    }

    @Override
    public void sell() {

    }
}
