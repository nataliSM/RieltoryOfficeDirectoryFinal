package ru.itis.inform.models.rieltoryModel;

/**
 * Created by Natalia on 05.11.16.
 */
public class Offer {
    private Integer id;
    private Address address;
    private Trader trader;
    private Feature feature;
    private Integer cost;

    public Offer(Integer id, Address address, Trader trader, Feature feature, Integer cost) {
        this.id = id;
        this.address = address;
        this.trader = trader;
        this.feature = feature;
        this.cost = cost;
    }

    public Offer() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", address=" + address +
                ", trader=" + trader +
                ", feature=" + feature +
                ", cost='" + cost + '\'' +
                '}';
    }
}
