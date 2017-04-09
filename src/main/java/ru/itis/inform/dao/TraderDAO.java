package ru.itis.inform.dao;

import ru.itis.inform.models.Trader;

/**
 * Created by Natalia on 06.11.16.
 */
public interface TraderDAO extends BaseDao<Trader>{
    public Integer save (Trader trader);
    public int findTrader(Trader trader);

}
