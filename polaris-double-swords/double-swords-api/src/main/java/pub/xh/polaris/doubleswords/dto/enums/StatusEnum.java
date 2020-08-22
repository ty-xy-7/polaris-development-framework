package pub.xh.polaris.doubleswords.dto.enums;

import java.io.Serializable;

/**
 * @Author xh
 * @Date 2020-12-07
 * @Description
 **/
public enum StatusEnum implements Serializable {
    /**
     * 业务数据取值成功状态
     */
    SUCCESS("10000", "成功"),
    /**
     * 业务数据取值异常状态
     */
    FAIL("10001", "异常"),
    /**
     * 为空异常
     */
    NULLFAIL("10002", "%s对象不能为空")
    ;

    StatusEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;

    public String getCode() {

        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static StatusEnum getByKey(int code){
        for (StatusEnum projectTypeEnum : values()){
            if (projectTypeEnum.getCode().equals(code)){
                return projectTypeEnum;
            }
        }
        return null;
    }
}