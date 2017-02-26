package ru.itis.inform.dao;

import ru.itis.inform.models.rieltoryModel.Feature;

/**
 * Created by Natalia on 05.11.16.
 */
public interface FeaturesDAO extends BaseDao<Feature>{
    public Integer save(Feature feature);
}
