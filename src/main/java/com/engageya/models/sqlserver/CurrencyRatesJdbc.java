package com.engageya.models.sqlserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;

/**
 * Created by LIOR on 21/05/2017.
 */
@Repository
public class CurrencyRatesJdbc {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("sqlserverDataSource")
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public CurrencyRate getRateByCurrencyAndDate(String currency, Date date) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT TOP 1 * FROM tbl_feed_currencyRates WITH(NOLOCK) ");
        sql.append("WHERE currency = '");
        sql.append(currency.toLowerCase());
        sql.append("' AND currency_date <= '");
        sql.append(date.toString() + "'");
        sql.append(" ORDER BY currency_date DESC");

        CurrencyRate currencyRate = (CurrencyRate) jdbcTemplate.queryForObject(sql.toString(),
                new BeanPropertyRowMapper(CurrencyRate.class));
        return currencyRate;
    }
}
