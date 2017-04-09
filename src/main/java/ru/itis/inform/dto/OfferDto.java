package ru.itis.inform.dto;

import ru.itis.inform.models.Address;
import ru.itis.inform.models.Feature;

/**
 * Created by Natalia on 09.04.17.
 */
public class OfferDto {
    private Integer id;
    private String cost;
    private FeatureDto feature;
    private TraderDto trader;
    private AddressDto address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public FeatureDto getFeature() {
        return feature;
    }

    public void setFeature(FeatureDto feature) {
        this.feature = feature;
    }

    public TraderDto getTrader() {
        return trader;
    }

    public void setTrader(TraderDto trader) {
        this.trader = trader;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
