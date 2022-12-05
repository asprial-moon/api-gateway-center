package cn.yong.gateway.center.domain.manage.service;

import cn.yong.gateway.center.application.IConfigManageService;
import cn.yong.gateway.center.domain.manage.model.vo.GatewayServerDetailVO;
import cn.yong.gateway.center.domain.manage.model.vo.GatewayServerVO;
import cn.yong.gateway.center.domain.manage.repository.IConfigManageRepository;
import cn.yong.gateway.center.infrastructure.common.Constants;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
