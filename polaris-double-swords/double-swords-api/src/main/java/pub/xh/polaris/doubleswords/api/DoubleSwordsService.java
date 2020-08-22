package pub.xh.polaris.doubleswords.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pub.xh.polaris.doubleswords.dto.response.base.SeibertronDTO;

/**
 * @Author xh
 * @Date 2020-12-07
 * @Description
 **/
@FeignClient(name = "polaris-double-swords", configuration = FeignClientsConfiguration.class)
public interface DoubleSwordsService {
    /**
     * 
     * @return
     */
    @GetMapping("transfer/getAutobots")
    SeibertronDTO getOptimusPrime();

    /**
     *
     * @param transType
     * @return
     */
    @GetMapping("transfer/getDecepticons/{transType}")
    SeibertronDTO getMegatron(@PathVariable("transType") String transType);
}