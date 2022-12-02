package cn.yong.gateway.center.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 网关配置管理；服务分组、网关注册、服务关联
 * @author Allen
 * @date 2022/12/2
 */
@RestController
@RequestMapping("wg/admin/config")
public class GatewayConfigManage {

    private Logger logger = LoggerFactory.getLogger(GatewayConfigManage.class);


}
