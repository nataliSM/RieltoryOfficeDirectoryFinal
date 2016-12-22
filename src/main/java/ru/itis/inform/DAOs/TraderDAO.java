package ru.itis.inform.DAOs;

import ru.itis.inform.models.rieltoryModel.Trader;

/**
 * Created by Natalia on 06.11.16.
 */
public interface TraderDAO {
    public Trader getTrader(Integer id);
    public int save (Trader trader);
    public int findTrader(Trader trader);

}
