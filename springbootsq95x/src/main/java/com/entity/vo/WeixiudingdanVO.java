package com.entity.vo;

import com.entity.WeixiudingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 维修订单
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-02-16 20:43:30
 */
public class WeixiudingdanVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 宿舍号
	 */
	
	private String sushehao;
		
	/**
	 * 宿舍位置
	 */
	
	private String susheweizhi;
		
	/**
	 * 学号
	 */
	
	private String xuehao;
		
	/**
	 * 学生姓名
	 */
	
	private String xueshengxingming;
		
	/**
	 * 报修原因
	 */
	
	private String baoxiuyuanyin;
		
	/**
	 * 申请日期
	 */
	
	private String shenqingriqi;
		
	/**
	 * 工号
	 */
	
	private String gonghao;
		
	/**
	 * 员工姓名
	 */
	
	private String yuangongxingming;
		
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
	 * 设置：报修原因
	 */
	 
	public void setBaoxiuyuanyin(String baoxiuyuanyin) {
		this.baoxiuyuanyin = baoxiuyuanyin;
	}
	
	/**
	 * 获取：报修原因
	 */
	public String getBaoxiuyuanyin() {
		return baoxiuyuanyin;
	}
				
	
	/**
	 * 设置：申请日期
	 */
	 
	public void setShenqingriqi(String shenqingriqi) {
		this.shenqingriqi = shenqingriqi;
	}
	
	/**
	 * 获取：申请日期
	 */
	public String getShenqingriqi() {
		return shenqingriqi;
	}
				
	
	/**
	 * 设置：工号
	 */
	 
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}
	
	/**
	 * 获取：工号
	 */
	public String getGonghao() {
		return gonghao;
	}
				
	
	/**
	 * 设置：员工姓名
	 */
	 
	public void setYuangongxingming(String yuangongxingming) {
		this.yuangongxingming = yuangongxingming;
	}
	
	/**
	 * 获取：员工姓名
	 */
	public String getYuangongxingming() {
		return yuangongxingming;
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
