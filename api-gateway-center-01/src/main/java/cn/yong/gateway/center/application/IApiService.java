package cn.yong.gateway.center.application;

import cn.yong.gateway.center.domain.model.ApiData;

import java.util.List;

/**
 * @desc API 服务
 * @author Allen
 * @date 2022/12/2
 */
public interface IApiService {

    List<ApiData> queryHttpStatementList();

}
