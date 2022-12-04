package cn.yong.gateway.center.domain.register.repository;

import cn.yong.gateway.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import cn.yong.gateway.center.domain.register.model.vo.ApplicationInterfaceVO;
import cn.yong.gateway.center.domain.register.model.vo.ApplicationSystemVO;

/**
 * @author Line
 * @desc 接口注册仓储服务
 * @date 2022/12/4
 */
public interface IRegisterManageRepository {

    void registerApplication(ApplicationSystemVO applicationSystemVO);

    void registerApplicationInterface(ApplicationInterfaceVO applicationInterfaceVO);

    void registerApplicationInterfaceMethod(ApplicationInterfaceMethodVO applicationInterfaceMethodVO);

}
