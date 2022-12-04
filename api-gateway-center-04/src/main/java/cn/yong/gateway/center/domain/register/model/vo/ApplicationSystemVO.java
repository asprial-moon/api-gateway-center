package cn.yong.gateway.center.domain.register.model.vo;

/**
 * @author Line
 * @desc 应用服务 VO
 * @date 2022/12/4
 */
public class ApplicationSystemVO {
    /**
     * 系统标识
     */
    private String systemId;
    /**
     * 系统名称
     */
    private String systemName;
    /**
     * 系统类型；RPC、HTTP
     */
    private String systemType;
    /**
     * 注册中心；zookeeper://127.0.0.1:2181
     */
    private String systemRegister;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public String getSystemRegister() {
        return systemRegister;
    }

    public void setSystemRegister(String systemRegister) {
        this.systemRegister = systemRegister;
    }
}
