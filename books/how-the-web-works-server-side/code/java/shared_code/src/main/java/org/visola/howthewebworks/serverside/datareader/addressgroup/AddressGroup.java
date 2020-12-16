package org.visola.howthewebworks.serverside.datareader.addressgroup;

import java.math.BigDecimal;

public class AddressGroup {

    private final BigDecimal latitude;
    private final BigDecimal longitude;
    private final String street;
    private final String zipCode;

    public AddressGroup(String[] values) {
        this.latitude = new BigDecimal(values[1]);
        this.longitude = new BigDecimal(values[0]);
        this.street = values[3];
        this.zipCode = values[8];
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

}