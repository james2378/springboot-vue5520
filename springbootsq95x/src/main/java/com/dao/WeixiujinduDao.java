package com.dao;

import com.entity.WeixiujinduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WeixiujinduVO;
import com.entity.view.WeixiujinduView;


/**
 * 维修进度
 * 
 * @author 
 * @email 
 * @date 2023-02-16 20:43:30
 */
public interface WeixiujinduDao extends BaseMapper<WeixiujinduEntity> {
	
	List<WeixiujinduVO> selectListVO(@Param("ew") Wrapper<WeixiujinduEntity> wrapper);
	
	WeixiujinduVO selectVO(@Param("ew") Wrapper<WeixiujinduEntity> wrapper);
	
	List<WeixiujinduView> selectListView(@Param("ew") Wrapper<WeixiujinduEntity> wrapper);

	List<WeixiujinduView> selectListView(Pagination page,@Param("ew") Wrapper<WeixiujinduEntity> wrapper);
	
	WeixiujinduView selectView(@Param("ew") Wrapper<WeixiujinduEntity> wrapper);
	

}
