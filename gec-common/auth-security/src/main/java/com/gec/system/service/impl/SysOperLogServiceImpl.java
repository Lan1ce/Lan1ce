package com.gec.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gec.model.system.SysOperLog;
import com.gec.model.vo.SysOperLogQueryVo;
import com.gec.system.mapper.SysOperLogMapper;
import com.gec.system.service.SysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service
@Transactional
public class SysOperLogServiceImpl implements SysOperLogService {

    @Autowired
    private SysOperLogMapper sysOperLogMapper;

    @Override
    public void recordOperLog(String operName, Integer status, String oper_ip, String result) {

    }

    @Override
    public IPage<SysOperLog> selectPage(Long page, Long limit, SysOperLogQueryVo sysOperLogQueryVo) {
        //创建page对象
        Page<SysOperLog> pageParam = new Page(page, limit);
        //获取条件值
        String operName = sysOperLogQueryVo.getOperName();
        String createTimeBegin = sysOperLogQueryVo.getCreateTimeBegin();
        String createTimeEnd = sysOperLogQueryVo.getCreateTimeEnd();
        //封装条件
        QueryWrapper<SysOperLog> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(operName)) {
            wrapper.like("oper_name", operName);
        }
        if (!StringUtils.isEmpty(createTimeBegin)) {
            wrapper.ge("create_time", createTimeBegin);
        }
        if (!StringUtils.isEmpty(createTimeBegin)) {
            wrapper.le("create_time", createTimeEnd);
        }
        //调用mapper方法
        IPage<SysOperLog> pageModel = sysOperLogMapper.selectPage(pageParam, wrapper);
        return pageModel;
    }

    @Override
    public SysOperLog getById(Long id) {
        return this.sysOperLogMapper.selectById(id);
    }
}
