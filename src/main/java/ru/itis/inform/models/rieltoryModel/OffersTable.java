package ru.itis.inform.models.rieltoryModel;

/**
 * Created by Natalia on 06.11.16.
 */
public class OffersTable {
    private Integer id;
    private Integer addressId;
    private Integer cityId;
    private String  cost;
    private Integer traderId;
    private Integer featureId;

    public OffersTable() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Integer getTraderId() {
        return traderId;
    }

    public void setTraderId(Integer traderId) {
        this.traderId = traderId;
    }

    public Integer getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Integer featureId) {
        this.featureId = featureId;
    }

    @Override
    public String toString() {
        return "OffersTable{" +
                "id=" + id +
                ", addressId=" + addressId +
                ", cityId=" + cityId +
                ", cost=" + cost +
                ", traderId=" + traderId +
                ", featureId=" + featureId +
                '}';
    }
}
