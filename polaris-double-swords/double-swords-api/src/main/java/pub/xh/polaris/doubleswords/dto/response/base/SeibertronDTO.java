package pub.xh.polaris.doubleswords.dto.response.base;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pub.xh.polaris.doubleswords.dto.enums.StatusEnum;

import java.io.Serializable;

/**
 * @Author xh
 * @Date 2020-12-07
 * @Description
 **/
public class SeibertronDTO<T> implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 返回错误还是正确
	 */
	private String status = StatusEnum.SUCCESS.getCode();
	
	/**
	 * 返回消息内容
	 */
    private String msg;

    /**
     * 返回的实体
     */
	private T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SeibertronDTO() {
    }

    public SeibertronDTO(String status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 异常返回
     * @param status 错误编码
     * @param msg  错误信息
     * @param data  再套一层的错误信息-目前使用ErrorDTO
     * @return ExecuteProcessDTO
     */
    public static <T> SeibertronDTO<T> error(String status, String msg, T data) {
        return new SeibertronDTO<T>(status, msg, data);
    }

    /**
     * 异常返回
     * @param status 错误编码
     * @param msg  错误信息
     * @return ExecuteResultDTO
     */
    public static <T> SeibertronDTO<T> error(String status, String msg) {
        return new SeibertronDTO<T>(status, msg, null);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}