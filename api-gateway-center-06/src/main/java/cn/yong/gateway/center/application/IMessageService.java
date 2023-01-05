package cn.yong.gateway.center.application;

import java.util.Map;

/**
 * 消息服务
 *
 * @author Allen
 * @date 2023/1/5
 */
public interface IMessageService {

    Map<String, String> queryRedisConfig();

    void pushMessage(String gatewayId, Object message);

}
