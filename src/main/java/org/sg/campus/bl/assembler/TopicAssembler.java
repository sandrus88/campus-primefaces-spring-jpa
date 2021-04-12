package org.sg.campus.bl.assembler;

import java.util.ArrayList;
import java.util.List;

import org.sg.campus.bl.entities.CourseEntity;
import org.sg.campus.bl.entities.TopicEntity;
import org.sg.campus.web.domain.Course;
import org.sg.campus.web.domain.Topic;

public class TopicAssembler {
	
	public static Topic getDTO(TopicEntity entity) {
		Topic dto = new Topic();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    //quando arrivi dal FE, e devi creare gli oggetti del DB
    public static TopicEntity getEntity(Topic dto) {
    	TopicEntity entity = new TopicEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public static List<Topic> getDTOList(List<TopicEntity> entityList) {
        List<Topic> list = new ArrayList<>();
        for (TopicEntity entity : entityList) {
            list.add(getDTO(entity));
        }
        return list;
    }

}
