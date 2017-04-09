package ru.itis.inform.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itis.inform.models.Trader;

/**
 * Created by Natalia on 09.04.17.
 */
public interface TraderRepository extends CrudRepository<Trader, Integer> {
}
