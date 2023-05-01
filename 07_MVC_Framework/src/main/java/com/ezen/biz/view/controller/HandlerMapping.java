package com.ezen.biz.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.ezen.biz.view.board.DeleteBoardController;
import com.ezen.biz.view.board.GetBoardController;
import com.ezen.biz.view.board.GetBoardListController;
import com.ezen.biz.view.board.InsertBoardController;
import com.ezen.biz.view.board.UpdateBoardController;
import com.ezen.biz.view.user.LoginController;
import com.ezen.biz.view.user.LogoutController;

public class HandlerMapping {

	private Map<String, CommonController> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, CommonController>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
	}
	
	public CommonController getController(String path) {
		return mappings.get(path);
	}
}
