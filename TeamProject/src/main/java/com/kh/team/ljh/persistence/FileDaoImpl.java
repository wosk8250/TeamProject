package com.kh.team.ljh.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class FileDaoImpl implements FileDao {

	@Inject
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "mappers.file-mapper.";
	//파일삭제
	@Override
	public void deleteFile(String files) throws Exception {
		sqlSession.delete(NAMESPACE + "deleteFile", files);
	}

}
