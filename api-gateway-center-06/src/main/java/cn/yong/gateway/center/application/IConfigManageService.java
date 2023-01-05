package cn.yong.gateway.center.application;

import cn.yong.gateway.center.domain.manage.model.aggregates.ApplicationSystemRichInfo;
import cn.yong.gateway.center.domain.manage.model.vo.GatewayServerVO;

import java.util.List;

/**
 * @desc 网关配置服务
 * @author Allen
 * @date 2022/12/2
 */
public interface IConfigManageService {

    List<GatewayServerVO> queryGatewayServerList();

    boolean registerGatewayServerNode(String groupId, String gatewayId, String gatewayName, String gatewayAddress);

    ApplicationSystemRichInfo queryApplicationSystemRichInfo(String gatewayId, String systemId);

    String queryGatewayDistribution(String systemId);
}
