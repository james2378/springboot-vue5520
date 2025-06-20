package com.entity.model;

import com.entity.LoudongxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 楼栋信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-02-16 20:43:30
 */
public class LoudongxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 地址
	 */
	
	private String dizhi;
		
	/**
	 * 建筑日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jianzhuriqi;
		
	/**
	 * 占地面积
	 */
	
	private String zhandimianji;
		
	/**
	 * 楼栋详情
	 */
	
	private String loudongxiangqing;
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：地址
	 */
	 
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	
	/**
	 * 获取：地址
	 */
	public String getDizhi() {
		return dizhi;
	}
				
	
	/**
	 * 设置：建筑日期
	 */
	 
	public void setJianzhuriqi(Date jianzhuriqi) {
		this.jianzhuriqi = jianzhuriqi;
	}
	
	/**
	 * 获取：建筑日期
	 */
	public Date getJianzhuriqi() {
		return jianzhuriqi;
	}
				
	
	/**
	 * 设置：占地面积
	 */
	 
	public void setZhandimianji(String zhandimianji) {
		this.zhandimianji = zhandimianji;
	}
	
	/**
	 * 获取：占地面积
	 */
	public String getZhandimianji() {
		return zhandimianji;
	}
				
	
	/**
	 * 设置：楼栋详情
	 */
	 
	public void setLoudongxiangqing(String loudongxiangqing) {
		this.loudongxiangqing = loudongxiangqing;
	}
	
	/**
	 * 获取：楼栋详情
	 */
	public String getLoudongxiangqing() {
		return loudongxiangqing;
	}
			
}
