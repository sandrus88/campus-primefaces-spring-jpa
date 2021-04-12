package org.sg.campus.bl.assembler;

import java.util.ArrayList;
import java.util.List;

import org.sg.campus.bl.entities.CourseEntity;
import org.sg.campus.web.domain.Course;

public class CourseAssembler {
	
	public static Course getDTO(CourseEntity entity) {
		Course dto = new Course();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public static CourseEntity getEntity(Course dto) {
    	CourseEntity entity = new CourseEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public static List<Course> getDTOList(List<CourseEntity> entityList) {
        List<Course> list = new ArrayList<>();
        for (CourseEntity entity : entityList) {
            list.add(getDTO(entity));
        }
        return list;
    }

}
