package ru.itis.inform.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.inform.models.Offer;

import java.util.List;

/**
 * Created by Natalia on 09.03.17.
 */
public interface OffersRepository extends CrudRepository<Offer, Integer>{
    @Query(value = "select offer from Offer offer  where  " +
            "offer.feature.countOfRoom = :countOfRoom and " +
            "offer.feature.condition = :condition and " +
            "offer.feature.repair = :repair and offer.address.city.name = :cityName and offer.cost <= :endCost and offer.cost >= :startCost ")
    List<Offer> getAllOffersWithParams (@Param("countOfRoom") int countOfRoom, @Param("condition") String condition, @Param("repair") String repair, @Param("cityName") String cityName,@Param("startCost") Integer startCost,@Param("endCost") Integer endCost);

    @Query(value = "UPDATE Offer offer set offer.cost = :cost where offer.id = :id")
    public void update(@Param("id") Integer id, @Param("cost") Integer cost);
}