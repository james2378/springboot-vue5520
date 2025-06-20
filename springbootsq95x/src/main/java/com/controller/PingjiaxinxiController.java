package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.PingjiaxinxiEntity;
import com.entity.view.PingjiaxinxiView;

import com.service.PingjiaxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 评价信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-16 20:43:30
 */
@RestController
@RequestMapping("/pingjiaxinxi")
public class PingjiaxinxiController {
    @Autowired
    private PingjiaxinxiService pingjiaxinxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PingjiaxinxiEntity pingjiaxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("weixiuyuan")) {
			pingjiaxinxi.setGonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			pingjiaxinxi.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PingjiaxinxiEntity> ew = new EntityWrapper<PingjiaxinxiEntity>();

		PageUtils page = pingjiaxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingjiaxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PingjiaxinxiEntity pingjiaxinxi, 
		HttpServletRequest request){
        EntityWrapper<PingjiaxinxiEntity> ew = new EntityWrapper<PingjiaxinxiEntity>();

		PageUtils page = pingjiaxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingjiaxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PingjiaxinxiEntity pingjiaxinxi){
       	EntityWrapper<PingjiaxinxiEntity> ew = new EntityWrapper<PingjiaxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( pingjiaxinxi, "pingjiaxinxi")); 
        return R.ok().put("data", pingjiaxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PingjiaxinxiEntity pingjiaxinxi){
        EntityWrapper< PingjiaxinxiEntity> ew = new EntityWrapper< PingjiaxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( pingjiaxinxi, "pingjiaxinxi")); 
		PingjiaxinxiView pingjiaxinxiView =  pingjiaxinxiService.selectView(ew);
		return R.ok("查询评价信息成功").put("data", pingjiaxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PingjiaxinxiEntity pingjiaxinxi = pingjiaxinxiService.selectById(id);
        return R.ok().put("data", pingjiaxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PingjiaxinxiEntity pingjiaxinxi = pingjiaxinxiService.selectById(id);
        return R.ok().put("data", pingjiaxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PingjiaxinxiEntity pingjiaxinxi, HttpServletRequest request){
    	pingjiaxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pingjiaxinxi);
        pingjiaxinxiService.insert(pingjiaxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PingjiaxinxiEntity pingjiaxinxi, HttpServletRequest request){
    	pingjiaxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pingjiaxinxi);
        pingjiaxinxiService.insert(pingjiaxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PingjiaxinxiEntity pingjiaxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(pingjiaxinxi);
        pingjiaxinxiService.updateById(pingjiaxinxi);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        pingjiaxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<PingjiaxinxiEntity> wrapper = new EntityWrapper<PingjiaxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("weixiuyuan")) {
			wrapper.eq("gonghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}

		int count = pingjiaxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<PingjiaxinxiEntity> ew = new EntityWrapper<PingjiaxinxiEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("weixiuyuan")) {
            ew.eq("gonghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = pingjiaxinxiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<PingjiaxinxiEntity> ew = new EntityWrapper<PingjiaxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("weixiuyuan")) {
            ew.eq("gonghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = pingjiaxinxiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<PingjiaxinxiEntity> ew = new EntityWrapper<PingjiaxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("weixiuyuan")) {
            ew.eq("gonghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = pingjiaxinxiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,PingjiaxinxiEntity pingjiaxinxi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("weixiuyuan")) {
            pingjiaxinxi.setGonghao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("xuesheng")) {
            pingjiaxinxi.setXuehao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<PingjiaxinxiEntity> ew = new EntityWrapper<PingjiaxinxiEntity>();
        int count = pingjiaxinxiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingjiaxinxi), params), params));
        return R.ok().put("data", count);
    }


}
