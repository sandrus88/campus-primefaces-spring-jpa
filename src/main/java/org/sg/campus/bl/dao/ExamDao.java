package org.sg.campus.bl.dao;

import org.sg.campus.bl.entities.ExamEntity;

import java.util.List;

public interface ExamDao {
    ExamEntity insert(ExamEntity examEntity);

    ExamEntity get(Integer id);

    ExamEntity update(ExamEntity examEntity);

    List<ExamEntity> getAll();

    boolean delete(Integer id);
}
