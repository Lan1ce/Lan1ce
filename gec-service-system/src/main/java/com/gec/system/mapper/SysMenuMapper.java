package com.gec.system.mapper;

import com.gec.model.system.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author Lan1ce
 * @since 2024-01-09
 */
@Repository
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    List<SysMenu> findListByUserId(@Param("userId") Long userId);
}
