package com.dj.app.controller.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dj.app.controller.common.Pager;
import com.dj.app.domain.Board;
import com.dj.app.exception.DMLException;
import com.dj.app.model.board.BoardService;

@Controller
public class BoardController {
	@Inject
	private BoardService boardService;
	
	@Inject
	private Pager pager;
	
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public String getList(Model model, HttpServletRequest request) {
		
		List boardList = boardService.selectAll();
		pager.init(boardList, request);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pager", pager);
		
		return "board/list";
	}
	
	@RequestMapping(value="/board/registForm", method=RequestMethod.GET)
	public String registForm() {
		return "board/registForm";
	}
	
	@RequestMapping(value="/board/detail", method=RequestMethod.GET)
	public String select(@RequestParam int board_id, Model model) {
		Board board= boardService.select(board_id);
		model.addAttribute("board", board);
		return "board/detail";
	}
	
	@RequestMapping(value="/board/regist", method=RequestMethod.POST)
	public String insert(Board board, Model model) {
		try {
			boardService.insert(board);
			model.addAttribute("msg", "등록성공");
			model.addAttribute("url", "/board/list");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DMLException("게시판 등록에 실패하였습니다", e);
		}
		return "result/message";
	}
	
	
	@RequestMapping(value="/board/edit", method=RequestMethod.POST)
	public String update(Board board, Model model) {
		
		try {
			boardService.update(board);
			model.addAttribute("msg", "수정성공");
			model.addAttribute("url", "/board/detail?board_id="+board.getBoard_id());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DMLException("게시판 수정에 실패하였습니다", e);
		}
		return "result/message";
	}
	
	@RequestMapping(value="/board/delete", method=RequestMethod.GET)
	public String del(Model model, @RequestParam int board_id) {
		try {
			boardService.delete(board_id);
			model.addAttribute("msg", "삭제성공");
			model.addAttribute("url", "/board/list");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DMLException("게시판 삭제에 실패하였습니다",e);
		}
		return "result/message";
	}
	
}




