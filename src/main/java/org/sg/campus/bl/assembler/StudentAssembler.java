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
        dto.setEmail(entity.getEmail());
        dto.setJobTitle(entity.getJobTitle());
        dto.setPaymentType(PaymentTypeAssembler.getEnum(entity.getPaymentType()));
        dto.setJobTitle(entity.getJobTitle());
        dto.setSex(entity.getSex());
        return dto;
    }

    //quando arrivi dal FE, e devi creare gli oggetti del DB
    public static StudentEntity getEntity(Student dto) {
        StudentEntity entity = new StudentEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setJobTitle(dto.getJobTitle());
        entity.setPaymentType(PaymentTypeAssembler.getString(dto.getPaymentType()));
        entity.setSex(dto.getSex());
        return entity;
    }

    public static List<Student> getDTOList(List<StudentEntity> entityList) {
        List<Student> list = new ArrayList<>();
        for (StudentEntity entity : entityList) {
            list.add(getDTO(entity));
        }
        return list;
    }


}
