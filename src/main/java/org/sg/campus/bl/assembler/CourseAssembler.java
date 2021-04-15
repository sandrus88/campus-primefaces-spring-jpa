package org.sg.campus.bl.assembler;

import java.util.ArrayList;
import java.util.List;

import org.sg.campus.bl.domain.Course;
import org.sg.campus.bl.entities.CourseEntity;

public class CourseAssembler {
	
	public static Course getDTO(CourseEntity entity) {
		if (entity == null) {
			return null;
		}
		
		Course dto = new Course();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setEnabled(entity.getEnabled());
        return dto;
    }

    public static CourseEntity getEntity(Course dto) {
    	if (dto == null) {
			return null;
		}
    	
    	CourseEntity entity = new CourseEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setEnabled(dto.getEnabled());
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
