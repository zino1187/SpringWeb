package com.dj.app.model.board;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.dj.app.domain.Board;
import com.dj.app.exception.DMLException;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Inject
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public List selectAll() {
		return sessionTemplate.selectList("Board.selectAll");
	}

	@Override
	public Board select(int board_id) {
		return sessionTemplate.selectOne("Board.select", board_id);
	}
	@Override
	public void insert(Board board) throws DMLException{
		int result = sessionTemplate.insert("Board.insert", board);
		if(result==0) {
			throw new DMLException("등록되지 않았습니다");
		}
		
	}
	@Override
	public void update(Board board)  throws DMLException{
		int result = sessionTemplate.update("Board.update", board);
		if(result==0) {
			throw new DMLException("수정되지 않았습니다");
		}		
	}

	@Override
	public void delete(int board_id)  throws DMLException{
		int result = sessionTemplate.delete("Board.delete",board_id);
		if(result==0) {
			throw new DMLException("삭제되지 않았습니다");
		}
	}
	
}
