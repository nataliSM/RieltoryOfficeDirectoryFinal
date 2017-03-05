package ru.itis.inform.dao.repository;
import org.hibernate.annotations.NamedNativeQueries;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.inform.models.rieltoryModel.City;

/**
 * Created by Natalia on 05.03.17.
 */
public interface CityRepository extends CrudRepository<City,Integer>{

    @Query(value = "select city.id from City city where city.name = :cityName")
    public int getCityId(@Param("cityName") String cityName);

}
