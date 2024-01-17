package com.gec.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gec.model.system.SysUser;
import com.gec.model.vo.SysUserQueryVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lan1ce
 * @since 2024-01-08
 */
public interface SysUserService extends IService<SysUser> {
    IPage<SysUser> selectPage(IPage<SysUser> iPage, SysUserQueryVo sysUserQueryVo);

    void updateStatus(Long id, Integer status);

    SysUser getUserInfoUserName(String username);

    Map<String, Object> getUserInfo(String username);

}
