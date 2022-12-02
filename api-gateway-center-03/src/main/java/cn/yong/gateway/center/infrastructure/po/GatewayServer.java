package cn.yong.gateway.center.infrastructure.po;

/**
 * @desc 网关服务
 * @author Allen
 * @date 2022/12/2
 */
public class GatewayServer {
    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 分组标识
     */
    private String groupId;
    /**
     * 分组名称
     */
    private String groupName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
