package com.mybootapp.mybootapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootapp.mybootapp.dto.Insert;
import com.mybootapp.mybootapp.dto.PagingDto;
import com.mybootapp.mybootapp.dao.DaoTest;
import com.mybootapp.mybootapp.dto.TestDto;
import com.mybootapp.mybootapp.dto.Update;

//@org.springframework.stereotype.Controller
@RestController
public class BootAppController {
	@Autowired
	private DaoTest dao ;
	
	@RequestMapping("/list")
	public String test(HttpServletRequest req , Model model) {
		HashMap<String , Object> paramMap = new HashMap<String ,Object>();

		String cntPerPage = "10";
		String nowPage = req.getParameter("nowPage");
		if(nowPage == null) {
			nowPage = "1";
		}
		int boardCount = dao.getCount();
		
		PagingDto pagingResult = new PagingDto(boardCount, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		paramMap.put("start", pagingResult.getStart());
		paramMap.put("end", pagingResult.getEnd());
		paramMap.put("cntPerPage", cntPerPage);
		paramMap.put("nowPage",nowPage);
		paramMap.put("endPage",pagingResult.getEnd());
		paramMap.put("lastPage", pagingResult.getLastPage());
		List<TestDto> result = dao.getList(paramMap);
		
		model.addAttribute("result",result);
		model.addAttribute("pagingParam",paramMap);
		return "test";
	}
	
	@DeleteMapping("/delete/{boardNum}")
	public String delete(@PathVariable String boardNum) {
		System.out.println("boardNum===>" + boardNum);
		try {
			dao.delete(boardNum);
			return "success";
		}catch(Error e) {
			return e.getMessage();
		}
	
	}
	
	@PostMapping("/insert")
	public String insert(@RequestBody Insert insertParams) {
		System.out.println("insertParams ===>"+insertParams);
		try {
			dao.insert(insertParams);
			return "success";
			
		}catch(Error e) {
			return e.getMessage();
		}
		
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Update updateParams) {
		System.out.println("updateParams ===>"+updateParams);
		try {
			dao.update(updateParams);
			return "success";
		}catch(Error e) {
			return e.getMessage();
		}
		
	}
	
}
