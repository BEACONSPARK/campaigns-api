package com.engageya.models.currencyrate;

import com.engageya.models.sqlserver.CurrencyRate;
import com.engageya.models.sqlserver.CurrencyRatesDao;
import com.engageya.models.sqlserver.CurrencyRatesJdbc;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LIOR on 18/05/2017.
 */
@Component
public class FixerIoCurrencyRateFetcher implements CurrencyRateFetcher {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(FixerIoCurrencyRateFetcher.class);

    @Autowired
    CurrencyRatesJdbc currencyRatesJdbc;

    @Autowired
    private CurrencyRatesDao currencyRatesDao;

    @Autowired
    RestTemplate restTemplate;

    private String url = "http://api.fixer.io/latest?base=USD";

    @Value("${currencies}")
    String currenciesString;
    List<String> currenciesList;

    @PostConstruct
    public void init() {
        try {
            this.currenciesList = Arrays.asList(currenciesString.split(","));

        } catch (Exception e) {
            logger.error("Error parsing  - currencies properties ", e);
        }
    }

    @Override
    public List<CurrencyRate> fetchRates() {
        ArrayList<CurrencyRate> responseList = new ArrayList<>();
        String jsonResponse = restTemplate.getForObject(url, String.class);
        try {
            JSONObject responseObject = new JSONObject(jsonResponse);
            Date date = Date.valueOf(responseObject.getString("date"));
            JSONObject rates = responseObject.getJSONObject("rates");
            for (String currency : currenciesList) {
                responseList.add(new CurrencyRate(currency.toLowerCase(), rates.getDouble(currency), date));
            }
        } catch (JSONException e) {
            logger.error("Error in fetch rates", e);
        }
        return responseList;
    }

    public CurrencyRate getRateByCurrencyAndDate(String currency, Date date) {
        return currencyRatesJdbc.getRateByCurrencyAndDate(currency, date);
    }

    public void save(CurrencyRate currencyRate) {
        currencyRatesDao.save(currencyRate);
    }

}
