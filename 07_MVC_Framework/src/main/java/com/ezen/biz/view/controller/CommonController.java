package com.ezen.biz.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommonController {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
