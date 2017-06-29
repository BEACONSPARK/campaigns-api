package com.engageya.models.currencyrate;

import com.engageya.models.sqlserver.CurrencyRate;

import java.sql.Date;
import java.util.List;

/**
 * Created by LIOR on 18/05/2017.
 */
public interface CurrencyRateFetcher {
    List<CurrencyRate> fetchRates();

    void save(CurrencyRate currencyRate);

    CurrencyRate getRateByCurrencyAndDate(String currency, Date date);
}
