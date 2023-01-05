package cn.yong.gateway.center.infrastructure.common;

/**
 * @desc 错误码
 * @author Allen
 * @date 2022/12/2
 */
public enum ResponseCode {

    SUCCESS("0000", "成功"),
    UN_ERROR("0001", "未知错误"),
    ILLEGAL_PARAMETER("0002", "非法参数"),
    INDEX_DUP("0003", "主键冲突"),
    NO_UPDATE("0004", "SQL操作无更新"),
    ;

    private String code;

    private String info;

    ResponseCode(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
