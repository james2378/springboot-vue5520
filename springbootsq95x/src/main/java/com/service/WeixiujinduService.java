package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WeixiujinduEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WeixiujinduVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WeixiujinduView;


/**
 * 维修进度
 *
 * @author 
 * @email 
 * @date 2023-02-16 20:43:30
 */
public interface WeixiujinduService extends IService<WeixiujinduEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeixiujinduVO> selectListVO(Wrapper<WeixiujinduEntity> wrapper);
   	
   	WeixiujinduVO selectVO(@Param("ew") Wrapper<WeixiujinduEntity> wrapper);
   	
   	List<WeixiujinduView> selectListView(Wrapper<WeixiujinduEntity> wrapper);
   	
   	WeixiujinduView selectView(@Param("ew") Wrapper<WeixiujinduEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeixiujinduEntity> wrapper);
   	

}

