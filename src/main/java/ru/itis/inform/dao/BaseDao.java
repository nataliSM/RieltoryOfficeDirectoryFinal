package ru.itis.inform.dao;

import java.util.List;

/**
 * Created by Natalia on 16.02.17.
 */
public interface BaseDao<Model> {
    /**
     * Сохраняет модель в хранилище данных
     * @param model сохраняемая модель
     * @return ID модели
     */
    Integer save(Model model);

    void update(Model model);

    Model find(Integer id);

    void delete(Integer id);

    List<Model> findAll();
}
