package cn.yong.gateway.center.interfaces;

import cn.yong.gateway.center.application.IConfigManageService;
import cn.yong.gateway.center.domain.manage.model.vo.GatewayServerVO;
import cn.yong.gateway.center.infrastructure.common.ResponseCode;
import cn.yong.gateway.center.infrastructure.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @desc 网关配置管理；服务分组、网关注册、服务关联
 * @author Allen
 * @date 2022/12/2
 */
@RestController
@RequestMapping("wg/admin/config")
public class GatewayConfigManage {

    private Logger logger = LoggerFactory.getLogger(GatewayConfigManage.class);

    @Autowired
    private IConfigManageService configManageService;

    @GetMapping(value = "queryServerConfig", produces = "application/json;charset=utf-8")
    public Result<List<GatewayServerVO>> queryServerConfig() {
        try {
            logger.info("查询网关服务配置项信息");
            List<GatewayServerVO> gatewayServerVOList = configManageService.queryGatewayServerList();
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), gatewayServerVOList);
        } catch (Exception e) {
            logger.error("查询网关服务配置项信息异常", e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), null);
        }
    }

    /**
     * 注册网关服务节点
     * @param groupId           分组标识
     * @param gatewayId         网关标识
     * @param gatewayName       网关名称
     * @param gatewayAddress    网关地址
     * @return  注册状态
     */
    @PostMapping(value = "registerGateway")
    public Result<Boolean> registerGatewayServerNode(@RequestParam String groupId, @RequestParam String gatewayId
            , @RequestParam String gatewayName, @RequestParam String gatewayAddress) {
        try {
            logger.info("注册网关服务节点 gatewayId:{} gatewayName:{}, gatewayAddress:{}", gatewayId, gatewayName, gatewayAddress);
            boolean done = configManageService.registerGatewayServerNode(groupId, gatewayId, gatewayName, gatewayAddress);
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), done);
        } catch (Exception e) {
            logger.info("注册网关服务节点异常", e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), false);
        }
    }

    /**
     * TODO 开发完成续应用注册后，开发这部分
     * @param groupId
     * @param gatewayId
     */
    @PostMapping(value = "distributionGateway")
    public void distributionGatewayServerNode(@RequestParam String groupId, @RequestParam String gatewayId) {

    }
}
