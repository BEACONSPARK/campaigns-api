package com.engageya.controllers;

import com.engageya.models.currencyrate.CurrencyRateFetcher;
import com.engageya.models.sqlserver.CurrencyRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;

/**
 * @author com.engageya
 */
@Controller
public class CurrencyRatesController {

    @RequestMapping("/currencyratesupdate")
    @ResponseBody
    public String updateCurrencyRates() {
        try {
            List<CurrencyRate> list = currencyRateFetcher.fetchRates();
            for (CurrencyRate currencyRate : list) {
                currencyRateFetcher.save(currencyRate);
            }
        } catch (Exception ex) {
            return "Error updating the currency rates: " + ex.toString();
        }
        return "Currency rates updated!";
    }

    @RequestMapping("/currencyratesgetrate")
    @ResponseBody
    public CurrencyRate getRateByCurrencyAndDate(@RequestParam(value = "currency", defaultValue = "") String currency,
                                                 @RequestParam(value = "date", defaultValue = "") String date) {
        return currencyRateFetcher.getRateByCurrencyAndDate(currency, Date.valueOf(date));
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    @Autowired
    CurrencyRateFetcher currencyRateFetcher;
}
