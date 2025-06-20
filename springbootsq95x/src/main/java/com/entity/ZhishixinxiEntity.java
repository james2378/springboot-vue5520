package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 知识信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-02-16 20:43:30
 */
@TableName("zhishixinxi")
public class ZhishixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZhishixinxiEntity() {
		
	}
	
	public ZhishixinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 知识名称
	 */
					
	private String zhishimingcheng;
	
	/**
	 * 知识封面
	 */
					
	private String zhishifengmian;
	
	/**
	 * 知识分类
	 */
					
	private String zhishifenlei;
	
	/**
	 * 注意事项
	 */
					
	private String zhuyishixiang;
	
	/**
	 * 知识简介
	 */
					
	private String zhishijianjie;
	
	/**
	 * 知识内容
	 */
					
	private String zhishineirong;
	
	/**
	 * 发布日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date faburiqi;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：知识名称
	 */
	public void setZhishimingcheng(String zhishimingcheng) {
		this.zhishimingcheng = zhishimingcheng;
	}
	/**
	 * 获取：知识名称
	 */
	public String getZhishimingcheng() {
		return zhishimingcheng;
	}
	/**
	 * 设置：知识封面
	 */
	public void setZhishifengmian(String zhishifengmian) {
		this.zhishifengmian = zhishifengmian;
	}
	/**
	 * 获取：知识封面
	 */
	public String getZhishifengmian() {
		return zhishifengmian;
	}
	/**
	 * 设置：知识分类
	 */
	public void setZhishifenlei(String zhishifenlei) {
		this.zhishifenlei = zhishifenlei;
	}
	/**
	 * 获取：知识分类
	 */
	public String getZhishifenlei() {
		return zhishifenlei;
	}
	/**
	 * 设置：注意事项
	 */
	public void setZhuyishixiang(String zhuyishixiang) {
		this.zhuyishixiang = zhuyishixiang;
	}
	/**
	 * 获取：注意事项
	 */
	public String getZhuyishixiang() {
		return zhuyishixiang;
	}
	/**
	 * 设置：知识简介
	 */
	public void setZhishijianjie(String zhishijianjie) {
		this.zhishijianjie = zhishijianjie;
	}
	/**
	 * 获取：知识简介
	 */
	public String getZhishijianjie() {
		return zhishijianjie;
	}
	/**
	 * 设置：知识内容
	 */
	public void setZhishineirong(String zhishineirong) {
		this.zhishineirong = zhishineirong;
	}
	/**
	 * 获取：知识内容
	 */
	public String getZhishineirong() {
		return zhishineirong;
	}
	/**
	 * 设置：发布日期
	 */
	public void setFaburiqi(Date faburiqi) {
		this.faburiqi = faburiqi;
	}
	/**
	 * 获取：发布日期
	 */
	public Date getFaburiqi() {
		return faburiqi;
	}

}
