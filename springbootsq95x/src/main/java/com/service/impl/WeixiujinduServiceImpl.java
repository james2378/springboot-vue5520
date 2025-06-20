package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.WeixiujinduDao;
import com.entity.WeixiujinduEntity;
import com.service.WeixiujinduService;
import com.entity.vo.WeixiujinduVO;
import com.entity.view.WeixiujinduView;

@Service("weixiujinduService")
public class WeixiujinduServiceImpl extends ServiceImpl<WeixiujinduDao, WeixiujinduEntity> implements WeixiujinduService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeixiujinduEntity> page = this.selectPage(
                new Query<WeixiujinduEntity>(params).getPage(),
                new EntityWrapper<WeixiujinduEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeixiujinduEntity> wrapper) {
		  Page<WeixiujinduView> page =new Query<WeixiujinduView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WeixiujinduVO> selectListVO(Wrapper<WeixiujinduEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeixiujinduVO selectVO(Wrapper<WeixiujinduEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeixiujinduView> selectListView(Wrapper<WeixiujinduEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeixiujinduView selectView(Wrapper<WeixiujinduEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
