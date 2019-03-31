package com.biz.email.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.biz.email.mapper.EmailDao;
import com.biz.email.model.EmailVO;

@Service
public class EmailService {

	@Autowired
	EmailDao dao;
	
	@Autowired
	ServletContext context;
	
	@Autowired
	SendMailService sMail;
	
	public List<EmailVO> selectAll(){
		return dao.selectAll();
	}
	
	public EmailVO findById(long id) {
		return dao.findById(id);
	}
	
	public int insert(EmailVO emailVO, 
					MultipartFile s_file1,
					MultipartFile s_file2) {
		String realPath= context.getRealPath("/files/");
		File dir=new File(realPath);
		if(!dir.exists()) dir.mkdir();
		
		if(!s_file1.isEmpty()) {
			String realName=s_file1.getOriginalFilename();
			String saveName=UUID.randomUUID().toString()+realName;
			
			File saveFile=new File(realPath,saveName);
			
			try {
				s_file1.transferTo(saveFile);
				emailVO.setS_file1(saveName);
				
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		if(!s_file2.isEmpty()) {
			String realName=s_file2.getOriginalFilename();
			String saveName=UUID.randomUUID().toString()+realName;
			
			File saveFile=new File(realPath,saveName);
			
			try {
				s_file2.transferTo(saveFile);
				emailVO.setS_file2(saveName);
				
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		sMail.sendMail(emailVO);
		
///////////////
		
		int ret = dao.insert(emailVO);
		
		return ret;
	}
	
	public int update(EmailVO emailVO,MultipartFile s_file1,
			MultipartFile s_file2) {
		String realPath= context.getRealPath("/files/");
		File dir=new File(realPath);
		if(!dir.exists()) dir.mkdir();
		
		if(!s_file1.isEmpty()) {
			String realName=s_file1.getOriginalFilename();
			String saveName=UUID.randomUUID().toString()+realName;
			
			File saveFile=new File(realPath,saveName);
			
			try {
				s_file1.transferTo(saveFile);
				emailVO.setS_file1(saveName);
				
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		if(!s_file2.isEmpty()) {
			String realName=s_file2.getOriginalFilename();
			String saveName=UUID.randomUUID().toString()+realName;
			
			File saveFile=new File(realPath,saveName);
			
			try {
				s_file2.transferTo(saveFile);
				emailVO.setS_file2(saveName);
				
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		int ret = dao.update(emailVO);
		return ret;
	}
	
	public int delete(long id) {
		return dao.delete(id);
	}
}
