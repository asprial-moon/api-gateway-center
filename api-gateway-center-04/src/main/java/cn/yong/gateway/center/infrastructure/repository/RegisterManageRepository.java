package cn.yong.gateway.center.infrastructure.repository;

import cn.yong.gateway.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import cn.yong.gateway.center.domain.register.model.vo.ApplicationInterfaceVO;
import cn.yong.gateway.center.domain.register.model.vo.ApplicationSystemVO;
import cn.yong.gateway.center.domain.register.repository.IRegisterManageRepository;
import cn.yong.gateway.center.infrastructure.dao.IApplicationInterfaceDao;
import cn.yong.gateway.center.infrastructure.dao.IApplicationInterfaceMethodDao;
import cn.yong.gateway.center.infrastructure.dao.IApplicationSystemDao;
import cn.yong.gateway.center.infrastructure.po.ApplicationInterface;
import cn.yong.gateway.center.infrastructure.po.ApplicationInterfaceMethod;
import cn.yong.gateway.center.infrastructure.po.ApplicationSystem;

import javax.annotation.Resource;

/**
 * @author Line
 * @desc 接口注册仓储服务
 * @date 2022/12/4
 */
public class RegisterManageRepository implements IRegisterManageRepository {
    @Resource
    private IApplicationSystemDao applicationSystemDao;
    @Resource
    private IApplicationInterfaceDao applicationInterfaceDao;
    @Resource
    private IApplicationInterfaceMethodDao applicationInterfaceMethodDao;

    @Override
    public void registerApplication(ApplicationSystemVO applicationSystemVO) {
        ApplicationSystem applicationSystem = new ApplicationSystem();
        applicationSystem.setSystemId(applicationSystemVO.getSystemId());
        applicationSystem.setSystemName(applicationSystemVO.getSystemName());
        applicationSystem.setSystemType(applicationSystemVO.getSystemType());
        applicationSystem.setSystemRegistry(applicationSystemVO.getSystemRegister());
        applicationSystemDao.insert(applicationSystem);
    }

    @Override
    public void registerApplicationInterface(ApplicationInterfaceVO applicationInterfaceVO) {
        ApplicationInterface applicationInterface = new ApplicationInterface();
        applicationInterface.setSystemId(applicationInterfaceVO.getSystemId());
        applicationInterface.setInterfaceId(applicationInterfaceVO.getInterfaceId());
        applicationInterface.setInterfaceName(applicationInterfaceVO.getInterfaceName());
        applicationInterface.setInterfaceVersion(applicationInterfaceVO.getInterfaceVersion());
        applicationInterfaceDao.insert(applicationInterface);
    }

    @Override
    public void registerApplicationInterfaceMethod(ApplicationInterfaceMethodVO applicationInterfaceMethodVO) {
        ApplicationInterfaceMethod applicationInterfaceMethod = new ApplicationInterfaceMethod();
        applicationInterfaceMethod.setSystemId(applicationInterfaceMethodVO.getSystemId());
        applicationInterfaceMethod.setInterfaceId(applicationInterfaceMethodVO.getInterfaceId());
        applicationInterfaceMethod.setMethodId(applicationInterfaceMethodVO.getMethodId());
        applicationInterfaceMethod.setMethodName(applicationInterfaceMethodVO.getMethodName());
        applicationInterfaceMethod.setParameterType(applicationInterfaceMethodVO.getParameterType());
        applicationInterfaceMethod.setUri(applicationInterfaceMethodVO.getUri());
        applicationInterfaceMethod.setHttpCommandType(applicationInterfaceMethodVO.getHttpCommandType());
        applicationInterfaceMethod.setAuth(applicationInterfaceMethodVO.getAuth());
        applicationInterfaceMethodDao.insert(applicationInterfaceMethod);
    }
}
