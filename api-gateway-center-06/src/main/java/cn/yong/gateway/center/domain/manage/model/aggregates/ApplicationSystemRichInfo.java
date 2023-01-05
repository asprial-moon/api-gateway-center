package cn.yong.gateway.center.domain.manage.model.aggregates;

import cn.yong.gateway.center.domain.register.model.vo.ApplicationSystemVO;

import java.util.List;

/**
 * 网关算力配置信息
 *
 * @author Allen
 * @date 2022/12/2
 */
public class ApplicationSystemRichInfo {
    /**
     * 网关ID
     */
    private String gatewayId;
    /**
     * 系统列表
     */
    private List<ApplicationSystemVO> applicationSystemVOList;

    public ApplicationSystemRichInfo() {
    }

    public ApplicationSystemRichInfo(String gatewayId, List<ApplicationSystemVO> applicationSystemVOList) {
        this.gatewayId = gatewayId;
        this.applicationSystemVOList = applicationSystemVOList;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public List<ApplicationSystemVO> getApplicationSystemVOList() {
        return applicationSystemVOList;
    }

    public void setApplicationSystemVOList(List<ApplicationSystemVO> applicationSystemVOList) {
        this.applicationSystemVOList = applicationSystemVOList;
    }
}
