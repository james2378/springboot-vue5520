package com.entity.model;

import com.entity.SushefenpeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 宿舍分配
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-02-16 20:43:30
 */
public class SushefenpeiModel  implements Serializable {
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
	
	private String renshu;
		
	/**
	 * 舍长
	 */
	
	private String shezhang;
		
	/**
	 * 宿舍配置
	 */
	
	private String sushepeizhi;
		
	/**
	 * 学号
	 */
	
	private String xuehao;
		
	/**
	 * 学生姓名
	 */
	
	private String xueshengxingming;
		
	/**
	 * 分配日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fenpeiriqi;
		
	/**
	 * 分配备注
	 */
	
	private String fenpeibeizhu;
				
	
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
	 
	public void setRenshu(String renshu) {
		this.renshu = renshu;
	}
	
	/**
	 * 获取：人数
	 */
	public String getRenshu() {
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
				
	
	/**
	 * 设置：学号
	 */
	 
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
				
	
	/**
	 * 设置：学生姓名
	 */
	 
	public void setXueshengxingming(String xueshengxingming) {
		this.xueshengxingming = xueshengxingming;
	}
	
	/**
	 * 获取：学生姓名
	 */
	public String getXueshengxingming() {
		return xueshengxingming;
	}
				
	
	/**
	 * 设置：分配日期
	 */
	 
	public void setFenpeiriqi(Date fenpeiriqi) {
		this.fenpeiriqi = fenpeiriqi;
	}
	
	/**
	 * 获取：分配日期
	 */
	public Date getFenpeiriqi() {
		return fenpeiriqi;
	}
				
	
	/**
	 * 设置：分配备注
	 */
	 
	public void setFenpeibeizhu(String fenpeibeizhu) {
		this.fenpeibeizhu = fenpeibeizhu;
	}
	
	/**
	 * 获取：分配备注
	 */
	public String getFenpeibeizhu() {
		return fenpeibeizhu;
	}
			
}
