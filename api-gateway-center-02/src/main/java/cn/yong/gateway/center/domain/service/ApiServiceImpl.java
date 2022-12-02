package cn.yong.gateway.center.domain.service;

import cn.yong.gateway.center.application.IApiService;
import cn.yong.gateway.center.domain.model.ApiData;
import cn.yong.gateway.center.domain.repository.IApiRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @desc API 服务
 * @author Allen
 * @date 2022/12/2
 */
@Service
public class ApiServiceImpl implements IApiService {

    @Resource
    private IApiRepository apiRepository;

    @Override
    public List<ApiData> queryHttpStatementList() {
        return apiRepository.queryHttpStatementList();
    }
}
