package ru.itis.inform.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itis.inform.models.rieltoryModel.Street;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Natalia on 09.03.17.
 */
public interface StreetRepository extends CrudRepository<Street, Integer>{

}
