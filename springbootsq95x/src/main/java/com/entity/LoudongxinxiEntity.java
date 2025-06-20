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
 * 楼栋信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-02-16 20:43:30
 */
@TableName("loudongxinxi")
public class LoudongxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LoudongxinxiEntity() {
		
	}
	
	public LoudongxinxiEntity(T t) {
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
	 * 楼号
	 */
					
	private String louhao;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	 * 设置：楼号
	 */
	public void setLouhao(String louhao) {
		this.louhao = louhao;
	}
	/**
	 * 获取：楼号
	 */
	public String getLouhao() {
		return louhao;
	}
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
