package cn.yong.gateway.center.domain.repository;

import cn.yong.gateway.center.domain.model.ApiData;

import java.util.List;

/**
 * @desc API 仓储
 * @author Allen
 * @date 2022/12/2
 */
public interface IApiRepository {

    List<ApiData> queryHttpStatementList();

}
