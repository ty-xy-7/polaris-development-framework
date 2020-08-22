package pub.xh.polaris.doubleswords.biz.impl;

import org.apache.dubbo.config.annotation.Service;
import pub.xh.polaris.doubleswords.api.DoubleSwordsService;
import pub.xh.polaris.doubleswords.dto.response.base.SeibertronDTO;

/**
 * @Author xh
 * @Date 2020-12-07
 * @Description
 **/
@Service
public class DoubleSwordsServiceImpl extends BaseImpl<DoubleSwordsServiceImpl> implements DoubleSwordsService {
    @Override
    public SeibertronDTO getOptimusPrime() {
        try{
        }catch (Exception e){
            LOGGER.error("XXXXXXX", e);
        }

        return this.writeSuccessToT("Autobots,transform", null);
    }

    @Override
    public SeibertronDTO getMegatron(String transType) {
        try{
        }catch (Exception e){
            LOGGER.error("XXXXXXX", e);
        }

        return this.writeSuccessToT("Decepticons,attack", null);
    }
}