package cn.yong.gateway.center.domain.manage.service;

import cn.yong.gateway.center.application.IConfigManageService;
import cn.yong.gateway.center.domain.manage.model.aggregates.ApplicationSystemRichInfo;
import cn.yong.gateway.center.domain.manage.model.vo.GatewayServerDetailVO;
import cn.yong.gateway.center.domain.manage.model.vo.GatewayServerVO;
import cn.yong.gateway.center.domain.manage.repository.IConfigManageRepository;
import cn.yong.gateway.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import cn.yong.gateway.center.domain.register.model.vo.ApplicationInterfaceVO;
import cn.yong.gateway.center.domain.register.model.vo.ApplicationSystemVO;
import cn.yong.gateway.center.infrastructure.common.Constants;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc 网关配置服务
 * @author Allen
 * @date 2022/12/2
 */
@Service
public class ConfigManageService implements IConfigManageService {
    @Resource
    private IConfigManageRepository configManageRepository;

    @Override
    public List<GatewayServerVO> queryGatewayServerList() {
        return configManageRepository.queryGatewayServerList();
    }

    @Override
    public boolean registerGatewayServerNode(String groupId, String gatewayId, String gatewayName, String gatewayAddress) {
        GatewayServerDetailVO gatewayServerDetailVO = configManageRepository.queryGatewayServerDetail(gatewayId, gatewayAddress);
        if (null == gatewayServerDetailVO) {
            try {
                return configManageRepository.registerGatewayServerNode(groupId, gatewayId, gatewayName, gatewayAddress, Constants.GatewayStatus.AVAILABLE);
            } catch (DuplicateKeyException e) {
                return configManageRepository.updateGatewayStatus(gatewayId, gatewayAddress, Constants.GatewayStatus.AVAILABLE);
            }
        } else {
            return configManageRepository.updateGatewayStatus(gatewayId, gatewayAddress, Constants.GatewayStatus.AVAILABLE);
        }
    }

    @Override
    public ApplicationSystemRichInfo queryApplicationSystemRichInfo(String gatewayId, String systemId) {
        // 1. 查询出网关ID对应的关联系统ID集合。也就是一个网关会被分配一些系统RPC服务注册进来，需要把这些服务查询出来。
        List<String> systemIdList = new ArrayList<>();
        if (null == systemId) {
            systemIdList = configManageRepository.queryGatewayDistributionSystemIdList(gatewayId);
        } else {
            systemIdList.add(systemId);
        }
        // 2. 查询系统ID对应的系统列表信息
        List<ApplicationSystemVO> applicationSystemVOList = configManageRepository.queryApplicationSystemList(systemIdList);
        // 3. 查询系统ID对应的系统列表信息
        // 思考：这里的查询是一个不断地循环的查询，你是否有有办法优化下，减少查询次数，
        for (ApplicationSystemVO applicationSystemVO : applicationSystemVOList) {
            List<ApplicationInterfaceVO> applicationInterfaceVOList = configManageRepository.queryApplicationInterfaceList(applicationSystemVO.getSystemId());
            for (ApplicationInterfaceVO applicationInterfaceVO : applicationInterfaceVOList) {
                List<ApplicationInterfaceMethodVO> applicationInterfaceMethodVOList = configManageRepository.queryApplicationInterfaceMethodList(applicationSystemVO.getSystemId(), applicationInterfaceVO.getInterfaceId());
                applicationInterfaceVO.setMethodList(applicationInterfaceMethodVOList);
            }
            applicationSystemVO.setInterfaceList(applicationInterfaceVOList);
        }
        return new ApplicationSystemRichInfo(gatewayId, applicationSystemVOList);
    }

    @Override
    public String queryGatewayDistribution(String systemId) {
        return configManageRepository.queryGatewayDistribution(systemId);
    }
}
