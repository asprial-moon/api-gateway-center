package cn.yong.gateway.center.infrastructure.repository;

import cn.yong.gateway.center.domain.model.ApiData;
import cn.yong.gateway.center.domain.repository.IApiRepository;
import cn.yong.gateway.center.infrastructure.dao.IHttpStatementDao;
import cn.yong.gateway.center.infrastructure.po.HttpStatement;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc 仓储实现
 * @author Allen
 * @date 2022/12/2
 */
@Component
public class ApiRepository implements IApiRepository {

    @Resource
    private IHttpStatementDao httpStatementDao;

    @Override
    public List<ApiData> queryHttpStatementList() {
        List<HttpStatement> httpStatements = httpStatementDao.queryHttpStatementList();
        List<ApiData> apiDataList = new ArrayList<>(httpStatements.size());
        for (HttpStatement httpStatement : httpStatements) {
            ApiData apiData = new ApiData();
            apiData.setApplication(httpStatement.getApplication());
            apiData.setInterfaceName(httpStatement.getInterfaceName());
            apiData.setMethodName(httpStatement.getMethodName());
            apiData.setParameterType(httpStatement.getParameterType());
            apiData.setUri(httpStatement.getUri());
            apiData.setHttpCommandType(httpStatement.getHttpCommandType());
            apiData.setAuth(httpStatement.getAuth());
            apiDataList.add(apiData);
        }
        return apiDataList;
    }
}
