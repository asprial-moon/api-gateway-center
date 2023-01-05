package cn.yong.gateway.center.domain.manage.repository;

import cn.yong.gateway.center.domain.manage.model.vo.GatewayServerDetailVO;
import cn.yong.gateway.center.domain.manage.model.vo.GatewayServerVO;

import java.util.List;

/**
 * @desc 网关配置仓储服务
 * @author Allen
 * @date 2022/12/2
 */
public interface IConfigManageRepository {

    List<GatewayServerVO> queryGatewayServerList();

    boolean registerGatewayServerNode(String groupId, String gatewayId, String gatewayName, String gatewayAddress, Integer available);

    GatewayServerDetailVO queryGatewayServerDetail(String gatewayId, String gatewayAddress);

    boolean updateGatewayStatus(String gatewayId, String gatewayAddress, Integer available);

}
