package com.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mp.dao.AreaMapper;
import com.mp.entity.Area;
import com.mp.service.AreaService;
import org.springframework.stereotype.Service;

/**
 * (Area)表服务实现类
 *
 * @author makejava
 * @since 2020-10-25 16:21:33
 */
@Service("areaService")
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {

}