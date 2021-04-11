package org.sg.campus.bl.service.impl;

import org.sg.campus.bl.assembler.StudentAssembler;
import org.sg.campus.bl.dao.AddressDao;
import org.sg.campus.bl.dao.StudentDao;
import org.sg.campus.bl.entities.AddressEntity;
import org.sg.campus.bl.entities.StudentEntity;
import org.sg.campus.bl.service.StudentService;
import org.sg.campus.web.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
	
	final private StudentDao studentDao;
	final private AddressDao addressDao;
	
	@Autowired
	public StudentServiceImpl(StudentDao studentDao, AddressDao addressDao) {
		this.studentDao = studentDao;
		this.addressDao = addressDao;
	}

	public StudentEntity insert(StudentEntity studentEntity) {
		return studentDao.insert(studentEntity);
	}

	public StudentEntity getStudent(Integer id) {
		return studentDao.get(id);
	}

	public StudentEntity update(StudentEntity studentEntity) {
		return studentDao.update(studentEntity);
	}

	public boolean deleteStudent(Integer id) {
		return studentDao.delete(id);
	}

	@Override
	public AddressEntity insert(AddressEntity addressEntity) {
		return addressDao.insert(addressEntity);
	}

	@Override
	public AddressEntity get(AddressEntity addressEntity) {
		return addressDao.get(addressEntity);
	}

	@Override
	public AddressEntity update(AddressEntity addressEntity) {
		return addressDao.update(addressEntity);
	}

	public void delete(AddressEntity addressEntity) {
		addressDao.delete(addressEntity);
	}

	@Override
	public List<Student> getAllStudents() {
		List<StudentEntity> entityList = studentDao.getAll();
		List<Student> dtoList = StudentAssembler.getDTO(entityList);
		return dtoList;
	}

	@Override
	public List<AddressEntity> getAllAddresses() {
		return addressDao.getAll();
	}


	@Override
	public List<Student> searchStudent(Student searchDto) {
		List<StudentEntity> listEntities = studentDao.searchStudent(searchDto);
		List<Student> list = StudentAssembler.getDTO(listEntities);
		return list;
	}
}
