package com.dj.app.model.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dj.app.domain.Board;
import com.dj.app.exception.DMLException;

@Service
public class BoardSeviceImpl implements BoardService{
	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public List selectAll() {
		return boardDAO.selectAll();
	}

	@Override
	public Board select(int board_id) {
		return boardDAO.select(board_id);
	}
	
	@Override
	public void insert(Board board) throws DMLException{
		boardDAO.insert(board);	
	}
	
	@Override
	public void update(Board board) throws DMLException {
		boardDAO.update(board);		
	}

	@Override
	public void delete(int board_id) throws DMLException {
		boardDAO.delete(board_id);
	}
	
}
