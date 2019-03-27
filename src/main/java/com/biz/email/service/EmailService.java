package com.biz.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.email.mapper.EmailDao;
import com.biz.email.model.EmailVO;

@Service
public class EmailService {

	@Autowired
	EmailDao dao;
	
	public List<EmailVO> selectAll(){
		return dao.selectAll();
	}
	
	public EmailVO findById(long id) {
		return dao.findById(id);
	}
	
	public int insert(EmailVO emailVO) {
		int ret = dao.insert(emailVO);
		return ret;
	}
	
	public int update(EmailVO emailVO) {
		int ret = dao.update(emailVO);
		return ret;
	}
	
	public int delete(long id) {
		return dao.delete(id);
	}
}
