package cn.yong.gateway.center.infrastructure.dao;

import cn.yong.gateway.center.infrastructure.po.ApplicationSystem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Line
 * @desc 应用系统
 * @date 2022/12/4
 */
@Mapper
public interface IApplicationSystemDao {

    void insert(ApplicationSystem applicationSystem);

    List<ApplicationSystem> queryApplicationSystemList(List<String> systemIdList);
}
