package com.gec.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gec.model.system.SysLoginLog;
import com.gec.model.vo.SysLoginLogQueryVo;

public interface SysLoginLogService  {
    /**
     * @param username
     * @param status
     * @param ipaddr
     * @param message
     */
    public void recordLoginLog(String username, Integer status, String ipaddr, String message);

    IPage<SysLoginLog> selectPage(Long page, Long limit, SysLoginLogQueryVo sysLoginLogQueryVo);

    SysLoginLog getById(Long id);
}
