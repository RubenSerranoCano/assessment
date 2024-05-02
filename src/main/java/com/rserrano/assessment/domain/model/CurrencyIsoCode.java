package com.rserrano.assessment.domain.model;

public enum CurrencyIsoCode {
    EUR("EUR"),
    USD("USD");

    public final String isoCode;

    CurrencyIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }
}
