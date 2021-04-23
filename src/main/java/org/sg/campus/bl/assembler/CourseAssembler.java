package org.sg.campus.bl.assembler;

import org.sg.campus.bl.domain.Course;
import org.sg.campus.bl.domain.Topic;
import org.sg.campus.bl.entities.CourseEntity;
import org.sg.campus.bl.entities.TopicEntity;

import java.util.ArrayList;
import java.util.List;

public class CourseAssembler {
    
    public static final int ENABLE_1 = 1;
    public static final int ENABLE_0 = 0;
	
	public static Course getDTO(CourseEntity entity) {
		if (entity == null) {
			return null;
		}
		
		Course dto = new Course();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setEnabled(getBooleanFromInt(entity.getEnable()));

        for (TopicEntity topicEntity : entity.getTopics()) {
            Topic topic  = TopicAssembler.getDTO(topicEntity);
            dto.addTopic(topic);
        }
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
        entity.setEnable(getIntFromBoolean(dto.getEnabled()));
        
        for (Topic topic : dto.getTopics()) {
            TopicEntity topicEntity  = TopicAssembler.getEntity(topic);
            entity.addTopic(topicEntity);
        }
        return entity;
    }
    
    public static boolean getBooleanFromInt(int i) {
        if (i == ENABLE_1) {
            return true;
        }
        return false;
    }
    
    public static int getIntFromBoolean(Boolean b) {
        if (b != null && b) {
            return ENABLE_1;
        }
        return ENABLE_0;
    }
    
    public static List<Course> getDTOList(List<CourseEntity> entityList) {
        List<Course> list = new ArrayList<>();
        for (CourseEntity entity : entityList) {
            list.add(getDTO(entity));
        }
        return list;
    }

}
