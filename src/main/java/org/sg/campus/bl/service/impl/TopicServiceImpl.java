package org.sg.campus.bl.service.impl;

import java.util.List;

import org.sg.campus.bl.assembler.TopicAssembler;
import org.sg.campus.bl.dao.TopicDao;
import org.sg.campus.bl.domain.Topic;
import org.sg.campus.bl.entities.TopicEntity;
import org.sg.campus.bl.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "topicService")
@Transactional
public class TopicServiceImpl implements TopicService {

	final private TopicDao topicDao;
	
	@Autowired
	public TopicServiceImpl(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	public Topic insert(Topic topic) {
		TopicEntity entity = TopicAssembler.getEntity(topic);
		entity = topicDao.insert(entity);
		topic = TopicAssembler.getDTO(entity);
		return topic;
	}

	public Topic getTopic(Integer id) {
		TopicEntity entity = topicDao.get(id);
		Topic topic = TopicAssembler.getDTO(entity);
		return topic;
	}

	public Topic update(Topic topic) {
		TopicEntity entity = TopicAssembler.getEntity(topic);
		TopicEntity entityUp = topicDao.update(entity);
		topic = TopicAssembler.getDTO(entityUp);
		return topic;
	}

	public boolean deleteTopic(Integer id) {
		return topicDao.delete(id);
	}

	@Override
	public List<Topic> getAllTopics() {
		List<TopicEntity> entityList = topicDao.getAll();
		List<Topic> dtoList = TopicAssembler.getDTOList(entityList);
		return dtoList;
	}

	@Override
	public List<Topic> searchTopic(Topic searchDto) {
		List<TopicEntity> listEntities = topicDao.searchTopic(searchDto);
		List<Topic> list = TopicAssembler.getDTOList(listEntities);
		return list;
	}
}
