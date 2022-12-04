package cn.yong.gateway.center.domain.register.service;

import cn.yong.gateway.center.application.IRegisterManageService;
import cn.yong.gateway.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import cn.yong.gateway.center.domain.register.model.vo.ApplicationInterfaceVO;
import cn.yong.gateway.center.domain.register.model.vo.ApplicationSystemVO;
import cn.yong.gateway.center.domain.register.repository.IRegisterManageRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Line
 * @desc 接口注册服务
 * @date 2022/12/4
 */
@Service
public class RegisterManageServiceImpl implements IRegisterManageService {

    @Resource
    private IRegisterManageRepository registerManageRepository;

    @Override
    public void registerApplication(ApplicationSystemVO applicationSystemVO) {
        registerManageRepository.registerApplication(applicationSystemVO);
    }

    @Override
    public void registerApplicationInterface(ApplicationInterfaceVO applicationInterfaceVO) {
        registerManageRepository.registerApplicationInterface(applicationInterfaceVO);
    }

    @Override
    public void registerApplicationInterfaceMethod(ApplicationInterfaceMethodVO applicationInterfaceMethodVO) {
        registerManageRepository.registerApplicationInterfaceMethod(applicationInterfaceMethodVO);
    }
}
