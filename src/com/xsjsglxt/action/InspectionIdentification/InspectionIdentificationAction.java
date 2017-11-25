package com.xsjsglxt.action.InspectionIdentification;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.VO.InspectionIdentification.CheckEntrustmentBookVO;
import com.xsjsglxt.service.InspectionIdentification.InspectionIdentificationService;

@SuppressWarnings("serial")
public class InspectionIdentificationAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	private InspectionIdentificationService inspectionIdentificationService;
	private HttpServletResponse response;
	private HttpServletRequest request;
	/**
	 * 
	 *
	 */
	// 痕迹检验委托书
	private xsjsglxt_check_entrustment_book tranceCheckBook;
	// 分页显示委托书
	private CheckEntrustmentBookVO checkEntrustmentBookVO;

	/**
	 * 
	 * 
	 */

	// 点击进入检验鉴定委托管理
	public String TranceCheckEntrustmentBookManagement() {
		return "TranceCheckEntrustmentBookManagement";
	}

	// 点击保存
	public void addCheckBook() {
		int i = inspectionIdentificationService.saveTranceCheckBook(tranceCheckBook);
		try {
			response.getWriter().write(i);
		} catch (IOException e) {
			System.out.println("保存委托书报错");
			e.printStackTrace();
		}
	}

	private void getListCheckEntrustmentBook() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		checkEntrustmentBookVO = inspectionIdentificationService.getListCheckEntrustmentBook(checkEntrustmentBookVO);
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write(gson.toJson(checkEntrustmentBookVO));
		} catch (IOException e) {
			System.out.println("分页显示委托书出错");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public CheckEntrustmentBookVO getCheckEntrustmentBookVO() {
		return checkEntrustmentBookVO;
	}

	public void setCheckEntrustmentBookVO(CheckEntrustmentBookVO checkEntrustmentBookVO) {
		this.checkEntrustmentBookVO = checkEntrustmentBookVO;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public xsjsglxt_check_entrustment_book getTranceCheckBook() {
		return tranceCheckBook;
	}

	public void setTranceCheckBook(xsjsglxt_check_entrustment_book tranceCheckBook) {
		this.tranceCheckBook = tranceCheckBook;
	}

	public void setInspectionIdentificationService(InspectionIdentificationService inspectionIdentificationService) {
		this.inspectionIdentificationService = inspectionIdentificationService;
	}

}
