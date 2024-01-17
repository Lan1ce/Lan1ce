package com.gec.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gec.model.system.SysOperLog;
import com.gec.model.vo.SysOperLogQueryVo;

public interface SysOperLogService {
    /**
     * @param username
     * @param status
     * @param ipaddr
     * @param message
     */
    public void recordOperLog(String username, Integer status, String ipaddr, String message);

    IPage<SysOperLog> selectPage(Long page, Long limit, SysOperLogQueryVo sysOperLogQueryVo);

    SysOperLog getById(Long id);
}
