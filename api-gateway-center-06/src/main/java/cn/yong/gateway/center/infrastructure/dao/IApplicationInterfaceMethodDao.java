package cn.yong.gateway.center.infrastructure.dao;

import cn.yong.gateway.center.infrastructure.po.ApplicationInterfaceMethod;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Line
 * @desc 应用接口方法
 * @date 2022/12/4
 */
@Mapper
public interface IApplicationInterfaceMethodDao {

    void insert(ApplicationInterfaceMethod applicationInterfaceMethod);

    List<ApplicationInterfaceMethod> queryApplicationInterfaceMethodList(ApplicationInterfaceMethod req);
}
