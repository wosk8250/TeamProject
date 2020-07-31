package com.kh.team.ljh.persistence;

import org.springframework.stereotype.Repository;

public interface FileDao {
	//파일삭제
	public void deleteFile(String files) throws Exception;
	
	
}
