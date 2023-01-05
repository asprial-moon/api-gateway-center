package cn.yong.gateway.center.infrastructure.dao;

import cn.yong.gateway.center.infrastructure.po.ApplicationInterface;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Line
 * @desc 应用接口
 * @date 2022/12/4
 */
@Mapper
public interface IApplicationInterfaceDao {

    void insert(ApplicationInterface applicationInterface);

    List<ApplicationInterface> queryApplicationInterfaceList(String systemId);
}
