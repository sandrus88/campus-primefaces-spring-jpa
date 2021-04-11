package org.sg.campus.bl.assembler;

import org.sg.campus.bl.entities.StudentEntity;
import org.sg.campus.web.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAssembler {

    // quando arrivi dal DB e presenti i dati nel FE
    public static Student getDTO(StudentEntity entity) {
        Student dto = new Student();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        // ..

        return dto;
    }

    //quando arrivi dal FE, e devi creare gli oggetti del DB
    public static StudentEntity getEntity(Student dto) {
        StudentEntity entity = new StudentEntity();
        entity.setId(entity.getId());
        entity.setName(entity.getName());
        entity.setSurname(entity.getSurname());
        // ..

        return entity;
    }

    public static List<Student> getDTO(List<StudentEntity> entityList) {
        List<Student> list = new ArrayList<>();
        for (StudentEntity entity : entityList) {
            list.add(getDTO(entity));
        }
        return list;
    }


}
