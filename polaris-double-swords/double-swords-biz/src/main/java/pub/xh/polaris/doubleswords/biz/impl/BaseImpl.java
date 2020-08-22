package pub.xh.polaris.doubleswords.biz.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pub.xh.polaris.doubleswords.dto.enums.StatusEnum;
import pub.xh.polaris.doubleswords.dto.response.base.SeibertronDTO;

import java.lang.reflect.ParameterizedType;

/**
 * @Author xh
 * @Date 2020-12-07
 * @Description
 **/
public class BaseImpl<T> {
    public Logger LOGGER = LoggerFactory.getLogger((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);

    public SeibertronDTO writeSuccessToT(Object data, String msg) {
        return this.writeToT(StatusEnum.SUCCESS, data, msg);
    }

    public SeibertronDTO writeFailToT(Object data, String msg) {
        return this.writeToT(StatusEnum.FAIL, data, msg);
    }

    public SeibertronDTO writeNullFailToT(Object data, String msg) {
        return this.writeToT(StatusEnum.NULLFAIL, data, msg);
    }

    /**
     * 通用返回
     * @param statusEnum
     * @param data
     * @param msg
     * @return
     */
    public SeibertronDTO writeToT(StatusEnum statusEnum, Object data, String msg) {
        SeibertronDTO seibertronDTO = new SeibertronDTO();
        seibertronDTO.setStatus(statusEnum.getCode());
        if(data != null){
            seibertronDTO.setData(data);
        }
        if(StringUtils.isNotBlank(msg)){
            seibertronDTO.setMsg(msg);
        }
        return seibertronDTO;
    }

    /**
     * 不用
     * @param data
     * @param msg
     * @return
     */
    private String writeSuccessToStr(Object data, String msg) {
        return this.writeToStr(StatusEnum.SUCCESS, data, msg);
    }

    /**
     * 不用
     * @param data
     * @param msg
     * @return
     */
    private String writeFailToStr(Object data, String msg) {
        return this.writeToStr(StatusEnum.FAIL, data, msg);
    }

    /**
     * 不用
     * @param statusEnum
     * @param data
     * @param msg
     * @return
     */
    private String writeToStr(StatusEnum statusEnum, Object data, String msg) {
        SeibertronDTO seibertronDTO = new SeibertronDTO();
        seibertronDTO.setStatus(statusEnum.getCode());
        if(data != null){
            seibertronDTO.setData(data);
        }
        if(StringUtils.isNotBlank(msg)){
            seibertronDTO.setMsg(msg);
        }
        return JSON.toJSONString(seibertronDTO, SerializerFeature.DisableCircularReferenceDetect);
    }
}