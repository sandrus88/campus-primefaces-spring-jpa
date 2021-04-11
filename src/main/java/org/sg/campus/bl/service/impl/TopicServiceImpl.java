package org.sg.campus.bl.service.impl;

import org.sg.campus.bl.dao.TopicDao;
import org.sg.campus.bl.entities.TopicEntity;
import org.sg.campus.bl.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
