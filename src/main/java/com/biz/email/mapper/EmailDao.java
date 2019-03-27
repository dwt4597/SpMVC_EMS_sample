package com.biz.email.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.email.model.EmailVO;

public interface EmailDao {

	@Select(" select * from tbl_emails ")
	public List<EmailVO> selectAll();
	
	@Select(" select * from tbl_emails where id = #{id} ")
	public EmailVO findById(long id);
	
	@InsertProvider(type=EmailSQL.class, method="email_insert_sql")
	public int insert(EmailVO emailVO);
	
	@UpdateProvider(type=EmailSQL.class, method="email_update_sql")
	public int update(EmailVO emailVO);
	
	@Delete("delete from tbl_emails where id=#{id}")
	public int delete(long id);
}
