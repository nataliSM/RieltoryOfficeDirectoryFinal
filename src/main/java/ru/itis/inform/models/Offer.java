package ru.itis.inform.models;

import javax.persistence.*;

/**
 * Created by Natalia on 05.11.16.
 */
@Entity
@Table (name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_flat")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn (name = "address_id")
    private Address address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "trader_id")
    private Trader trader;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "features_id")
    private Feature feature;
    @Column
    private Integer cost;

    public Offer(Integer id, Address address, Trader trader, Feature feature, Integer cost) {
        this.id = id;
        this.address = address;
        this.trader = trader;
        this.feature = feature;
        this.cost = cost;
    }

    public Offer(Integer id) {
        this.id = id;
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
