package ru.itis.inform.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itis.inform.models.Feature;

/**
 * Created by Natalia on 09.03.17.
 */
public interface FeaturesRepository extends CrudRepository<Feature, Integer> {
}
