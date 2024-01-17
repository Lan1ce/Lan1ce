package com.gec.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gec.model.system.SysOperLog;
import com.gec.model.vo.SysOperLogQueryVo;
import com.gec.system.common.Result;
import com.gec.system.service.SysOperLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api("登录操作控制器")
@RestController
@RequestMapping("/admin/system/sysOperLog")
public class SysOperLogController {

    @Autowired
    private SysOperLogService sysOperLogService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("{page}/{limit}")
    public Result QueryOperLog(@PathVariable Long page,
                                @PathVariable Long limit,
                                SysOperLogQueryVo sysOperLogQueryVo) {
        IPage<SysOperLog> iPage = sysOperLogService.selectPage(page, limit, sysOperLogQueryVo);
        return Result.ok(iPage);
    }

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SysOperLog sysOperLog = sysOperLogService.getById(id);
        return Result.ok(sysOperLog);
    }
}




