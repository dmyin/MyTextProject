package com.dmyin.dao;



import com.dmyin.pojo.Tag;

import java.util.List;

public interface TagDao {
    Long courseCount(Integer id);

    List<Tag> courseTag(Integer id);

    void addCourseTag(Tag tag);
}
