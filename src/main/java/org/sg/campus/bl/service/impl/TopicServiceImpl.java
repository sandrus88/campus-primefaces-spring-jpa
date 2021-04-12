package org.sg.campus.bl.service.impl;

import java.util.List;

import org.sg.campus.bl.assembler.TopicAssembler;
import org.sg.campus.bl.dao.TopicDao;
import org.sg.campus.bl.entities.TopicEntity;
import org.sg.campus.bl.service.TopicService;
import org.sg.campus.web.domain.Topic;
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

	@Override
	public TopicEntity insert(TopicEntity topicEntity) {
		return topicDao.insert(topicEntity);
	}

	@Override
	public TopicEntity get(Integer id) {
		return topicDao.get(id);
	}

	@Override
	public TopicEntity update(TopicEntity topicEntity) {
		return topicDao.update(topicEntity);
	}

	@Override
	public boolean delete(Integer id) {
		return topicDao.delete(id);
	}

	@Override
	public List<TopicEntity> getAll() {
		return topicDao.getAll();
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
