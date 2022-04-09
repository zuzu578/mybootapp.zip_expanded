package com.mybootapp.mybootapp.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mybootapp.mybootapp.dto.Insert;
import com.mybootapp.mybootapp.dto.PagingDto;
import com.mybootapp.mybootapp.dao.DaoTest;
import com.mybootapp.mybootapp.dto.TestDto;
import com.mybootapp.mybootapp.dto.Update;


@RestController
public class BootAppController {
	// 파일 업로드 경로
	private static String FileSavePath = "/Users/helloworld/eclipse-workspace/mybootapp.zip_expanded/mybootapp/src/main/webapp/resources/assets";

	@Autowired
	private DaoTest dao;

	@GetMapping("/list")
	public HashMap<String,Object> test(HttpServletRequest req) {
		HashMap<String,Object> result1 = new HashMap<String,Object>(); 
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		String cntPerPage = "10";
		String nowPage = req.getParameter("nowPage");
		if (nowPage == null) {
			nowPage = "1";
		}
		int boardCount = dao.getCount();

		PagingDto pagingResult = new PagingDto(boardCount, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		paramMap.put("start", pagingResult.getStart());
		paramMap.put("end", pagingResult.getEnd());
		paramMap.put("cntPerPage", cntPerPage);
		paramMap.put("nowPage", nowPage);
		paramMap.put("endPage", pagingResult.getEnd());
		paramMap.put("lastPage", pagingResult.getLastPage());
		List<TestDto> result = dao.getList(paramMap);
		result1.put("data", result);
		
		return result1;
		
	}

	@DeleteMapping("/delete/{boardNum}")
	public String delete(@PathVariable String boardNum) {
		System.out.println("boardNum===>" + boardNum);
		try {
			dao.delete(boardNum);
			return "success";
		} catch (Error e) {
			return e.getMessage();
		}

	}
	
	@PostMapping("/insert")
	public String insert(@RequestBody Insert insertParams) {
		System.out.println("insertParams ===>" + insertParams);
		try {
			dao.insert(insertParams);
			return "success";

		} catch (Error e) {
			return e.getMessage();
		}

	}

	@PutMapping("/update")
	public String update(@RequestBody Update updateParams) {
		System.out.println("updateParams ===>" + updateParams);
		try {
			
			dao.update(updateParams);
			return "success";
		} catch (Error e) {
			return e.getMessage();
		}

	}

	// 파일 업로드 페이지 이동
	@RequestMapping("/file")
	public String file() {

		return "file";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadForm(MultipartFile file, ModelAndView mv) {
		try {
			// 업로드한 파일의 원본 이름을 가져온다.
			String fileName = file.getOriginalFilename();
			File target = new File(FileSavePath, fileName);
			// 지정경로가 없는경우, 파일경로를 생성해준다.
			if (!new File(FileSavePath).exists()) {
				new File(FileSavePath).mkdirs();
			}
			// 파일 복사
			try {
				FileCopyUtils.copy(file.getBytes(), target);
				mv.addObject("file", file);
			} catch (Exception e) {
				e.printStackTrace();
				mv.addObject("file", "error");
			}
			return "success";
		} catch (Error e) {
			return e.getMessage();
		}
	}

}
