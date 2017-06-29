package com.engageya.models.sqlserver;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Entity
@Table(name = "tbl_feed_currencyRates")
public class CurrencyRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "row_id")
    private long rowId;

    @NotNull
    private String currency;

    @NotNull
    @Column(name = "currency_rate")
    private double currencyRate;

    @NotNull
    @Column(name = "currency_date")
    private Date currencyDate;

    public CurrencyRate() {
    }

    public CurrencyRate(String currency, double currency_rate, Date currency_date) {
        this.currency = currency;
        this.currencyRate = currency_rate;
        this.currencyDate = currency_date;
    }

    public long getRowId() {
        return rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(double currencyRate) {
        this.currencyRate = currencyRate;
    }

    public Date getCurrencyDate() {
        return currencyDate;
    }

    public void setCurrencyDate(Date currencyDate) {
        this.currencyDate = currencyDate;
    }


}
