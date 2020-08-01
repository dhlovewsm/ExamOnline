package com.examonline.common.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @version V1.0
 * @author donghao
 * @className BaseMapper
 * @packageName com.examonline.common.base
 * @description 通用mapper，基础接口，为其它实体类mapper接口调用
 * @date 2019/04/03
 * @param <T>
 * @Copyright(c) www.bosssoft.com.cn
 */

public interface BaseMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
