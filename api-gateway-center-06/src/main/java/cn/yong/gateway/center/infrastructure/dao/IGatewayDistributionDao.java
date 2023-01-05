package cn.yong.gateway.center.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Allen
 * @desc 网关分配
 * @date 2022/12/5
 */
@Mapper
public interface IGatewayDistributionDao {

    List<String> queryGatewayDistributionSystemIdList();

}
