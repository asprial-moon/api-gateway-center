package cn.yong.gateway.center.infrastructure.dao;

import cn.yong.gateway.center.infrastructure.po.HttpStatement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @desc 网关接口映射信息表DAO
 * @author Allen
 * @date 2022/12/2
 */
@Mapper
public interface IHttpStatementDao {

    List<HttpStatement> queryHttpStatementList();

}
