package org.sg.campus.bl.assembler;

import java.util.ArrayList;
import java.util.List;

import org.sg.campus.bl.domain.Topic;
import org.sg.campus.bl.entities.TopicEntity;

public class TopicAssembler {
	
	public static Topic getDTO(TopicEntity entity) {
		if (entity == null) {
			return null;
		}
		
		Topic dto = new Topic();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public static TopicEntity getEntity(Topic dto) {
    	if (dto == null) {
			return null;
		}
    	
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
