package com.dao;

import com.entity.DiscusszhishixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszhishixinxiVO;
import com.entity.view.DiscusszhishixinxiView;


/**
 * 知识信息评论表
 * 
 * @author 
 * @email 
 * @date 2023-02-16 20:43:30
 */
public interface DiscusszhishixinxiDao extends BaseMapper<DiscusszhishixinxiEntity> {
	
	List<DiscusszhishixinxiVO> selectListVO(@Param("ew") Wrapper<DiscusszhishixinxiEntity> wrapper);
	
	DiscusszhishixinxiVO selectVO(@Param("ew") Wrapper<DiscusszhishixinxiEntity> wrapper);
	
	List<DiscusszhishixinxiView> selectListView(@Param("ew") Wrapper<DiscusszhishixinxiEntity> wrapper);

	List<DiscusszhishixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhishixinxiEntity> wrapper);
	
	DiscusszhishixinxiView selectView(@Param("ew") Wrapper<DiscusszhishixinxiEntity> wrapper);
	

}
