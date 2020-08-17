package com.dmyin.dao;



import com.dmyin.pojo.Catalog;

import java.util.List;

public interface CatalogDao {
    Long courseCount(Integer id);

    List<Catalog> findIdAndName(Integer CourseId);
}
