package com.entity.vo;

import com.entity.SushexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 宿舍信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-02-16 20:43:30
 */
public class SushexinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 宿舍号
	 */
	
	private String sushehao;
		
	/**
	 * 宿舍图片
	 */
	
	private String sushetupian;
		
	/**
	 * 宿舍位置
	 */
	
	private String susheweizhi;
		
	/**
	 * 人数
	 */
	
	private Integer renshu;
		
	/**
	 * 舍长
	 */
	
	private String shezhang;
		
	/**
	 * 宿舍配置
	 */
	
	private String sushepeizhi;
				
	
	/**
	 * 设置：宿舍号
	 */
	 
	public void setSushehao(String sushehao) {
		this.sushehao = sushehao;
	}
	
	/**
	 * 获取：宿舍号
	 */
	public String getSushehao() {
		return sushehao;
	}
				
	
	/**
	 * 设置：宿舍图片
	 */
	 
	public void setSushetupian(String sushetupian) {
		this.sushetupian = sushetupian;
	}
	
	/**
	 * 获取：宿舍图片
	 */
	public String getSushetupian() {
		return sushetupian;
	}
				
	
	/**
	 * 设置：宿舍位置
	 */
	 
	public void setSusheweizhi(String susheweizhi) {
		this.susheweizhi = susheweizhi;
	}
	
	/**
	 * 获取：宿舍位置
	 */
	public String getSusheweizhi() {
		return susheweizhi;
	}
				
	
	/**
	 * 设置：人数
	 */
	 
	public void setRenshu(Integer renshu) {
		this.renshu = renshu;
	}
	
	/**
	 * 获取：人数
	 */
	public Integer getRenshu() {
		return renshu;
	}
				
	
	/**
	 * 设置：舍长
	 */
	 
	public void setShezhang(String shezhang) {
		this.shezhang = shezhang;
	}
	
	/**
	 * 获取：舍长
	 */
	public String getShezhang() {
		return shezhang;
	}
				
	
	/**
	 * 设置：宿舍配置
	 */
	 
	public void setSushepeizhi(String sushepeizhi) {
		this.sushepeizhi = sushepeizhi;
	}
	
	/**
	 * 获取：宿舍配置
	 */
	public String getSushepeizhi() {
		return sushepeizhi;
	}
			
}
