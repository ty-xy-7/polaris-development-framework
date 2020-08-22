package pub.xh.polaris.doubleswords.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pub.xh.polaris.doubleswords.api.DoubleSwordsService;
import pub.xh.polaris.doubleswords.dto.response.base.SeibertronDTO;

/**
 * @Author xh
 * @Date 2020-12-07
 * @Description
 **/
@RestController
@RequestMapping("transfer")
@Api(tags={"Feign服务方"})
public class FeignProviderController {
    @Autowired
    private DoubleSwordsService doubleSwordsService;

    @GetMapping("getAutobots")
    @ApiOperation(value = "当前接口是无参数的",httpMethod = "GET")
    public SeibertronDTO getAutobots() {
        SeibertronDTO seibertronDTO = null;
        try{
            seibertronDTO = this.doubleSwordsService.getOptimusPrime();
        }catch (Exception e){
        }
        return seibertronDTO;
    }

    @GetMapping("getDecepticons/{transType}")
    @ApiOperation(value = "当前接口是有参数的",httpMethod = "GET")
    public SeibertronDTO getDecepticons(@PathVariable("transType") String transType) {
        SeibertronDTO seibertronDTO = null;
        try{
            seibertronDTO = this.doubleSwordsService.getMegatron(transType);
        }catch (Exception e){
        }
        return seibertronDTO;
    }
}