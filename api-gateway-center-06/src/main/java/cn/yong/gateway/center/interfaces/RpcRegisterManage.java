package cn.yong.gateway.center.interfaces;

import cn.yong.gateway.center.application.IConfigManageService;
import cn.yong.gateway.center.application.IMessageService;
import cn.yong.gateway.center.application.IRegisterManageService;
import cn.yong.gateway.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import cn.yong.gateway.center.domain.register.model.vo.ApplicationInterfaceVO;
import cn.yong.gateway.center.domain.register.model.vo.ApplicationSystemVO;
import cn.yong.gateway.center.infrastructure.common.ResponseCode;
import cn.yong.gateway.center.infrastructure.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Line
 * @desc Rpc 服务注册管理
 * @date 2022/12/4
 */
@RestController
@RequestMapping("/wg/admin/register")
public class RpcRegisterManage {

    private Logger logger = LoggerFactory.getLogger(RpcRegisterManage.class);
    @Resource
    private IRegisterManageService registerManageService;
    @Autowired
    private IConfigManageService configManageService;
    @Autowired
    private IMessageService messageService;

    @PostMapping(value = "registerApplication", produces = "application/json;charset=utf-8")
    public Result<Boolean> registerApplication(@RequestParam String systemId,
                                               @RequestParam String systemName,
                                               @RequestParam String systemType,
                                               @RequestParam String systemRegister) {
        try {
            logger.info("注册应用服务 systemId: {}", systemId);
            ApplicationSystemVO applicationSystemVO = new ApplicationSystemVO();
            applicationSystemVO.setSystemId(systemId);
            applicationSystemVO.setSystemName(systemName);
            applicationSystemVO.setSystemType(systemType);
            applicationSystemVO.setSystemRegister(systemRegister);
            registerManageService.registerApplication(applicationSystemVO);
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), true);
        } catch (DuplicateKeyException e) {
            logger.warn("注册应用服务重复 systemId: {}", systemId, e);
            return new Result<>(ResponseCode.INDEX_DUP.getCode(), e.getMessage(), true);
        } catch (Exception e) {
            logger.error("注册应用服务失败 systemId: {}", systemId, e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), false);
        }
    }

    @PostMapping(value = "registerApplicationInterface", produces = "application/json;charset=utf-8")
    public Result<Boolean> registerApplicationInterface(@RequestParam String systemId,
                                                        @RequestParam String interfaceId,
                                                        @RequestParam String interfaceName,
                                                        @RequestParam String interfaceVersion) {
        try {
            logger.info("注册应用接口 systemId: {} interfaceId: {}", systemId, interfaceId);
            ApplicationInterfaceVO applicationInterfaceVO = new ApplicationInterfaceVO();
            applicationInterfaceVO.setSystemId(systemId);
            applicationInterfaceVO.setInterfaceId(interfaceId);
            applicationInterfaceVO.setInterfaceName(interfaceName);
            applicationInterfaceVO.setInterfaceVersion(interfaceVersion);
            registerManageService.registerApplicationInterface(applicationInterfaceVO);
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), true);
        }  catch (DuplicateKeyException e) {
            logger.warn("注册应用接口重复 systemId: {} interfaceId: {}", systemId, interfaceId, e);
            return new Result<>(ResponseCode.INDEX_DUP.getCode(), e.getMessage(), true);
        } catch (Exception e) {
            logger.error("注册应用接口失败 systemId: {}", systemId, e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), false);
        }
    }

    @PostMapping(value = "registerApplicationInterfaceMethod", produces = "application/json;charset=utf-8")
    public Result<Boolean> registerApplicationInterfaceMethod(@RequestParam String systemId,
                                                              @RequestParam String interfaceId,
                                                              @RequestParam String methodId,
                                                              @RequestParam String methodName,
                                                              @RequestParam String parameter_type,
                                                              @RequestParam String uri,
                                                              @RequestParam String httpCommandType,
                                                              @RequestParam Integer auth) {
        try {
            logger.info("注册应用接口方法 systemId: {} interfaceId: {} methodId: {}", systemId, interfaceId, methodId);
            ApplicationInterfaceMethodVO applicationInterfaceMethodVO = new ApplicationInterfaceMethodVO();
            applicationInterfaceMethodVO.setSystemId(systemId);
            applicationInterfaceMethodVO.setInterfaceId(interfaceId);
            applicationInterfaceMethodVO.setMethodId(methodId);
            applicationInterfaceMethodVO.setMethodId(methodName);
            applicationInterfaceMethodVO.setParameterType(parameter_type);
            applicationInterfaceMethodVO.setUri(uri);
            applicationInterfaceMethodVO.setHttpCommandType(httpCommandType);
            applicationInterfaceMethodVO.setAuth(auth);
            registerManageService.registerApplicationInterfaceMethod(applicationInterfaceMethodVO);
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), true);
        } catch (DuplicateKeyException e) {
            logger.warn("注册应用接口重复 systemId: {} interfaceId: {}", systemId, interfaceId);
            return new Result<>(ResponseCode.INDEX_DUP.getCode(), e.getMessage(), true);
        } catch (Exception e) {
            logger.error("注册应用接口失败 systemId: {}", systemId, e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), false);
        }
    }

    @PostMapping(value = "registerEvent", produces = "application/json;charset=utf-8")
    public Result<Boolean> registerEvent(@RequestParam String systemId) {
        try {
            logger.info("应用信息注册完成通知 systemId：{}", systemId);
            // 推送注册信息
            String gatewayId = configManageService.queryGatewayDistribution(systemId);
            messageService.pushMessage(gatewayId, systemId);
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.UN_ERROR.getInfo(), true);
        } catch (Exception e) {
            logger.error("应用信息注册完成通知失败 systemId：{}", systemId, e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), false);
        }
    }
}
