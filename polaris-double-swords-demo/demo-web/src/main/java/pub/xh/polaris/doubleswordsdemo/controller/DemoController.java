package pub.xh.polaris.doubleswordsdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pub.xh.polaris.doubleswords.api.DoubleSwordsService;
import pub.xh.polaris.doubleswords.dto.response.base.SeibertronDTO;

/**
 * @Author xh
 * @Date 2020-07-30
 * @Description 启动类
 **/
@RestController
@RequestMapping("transfer")
@Api(tags={"双剑合并"})
class DemoController {
    @Autowired
    private DoubleSwordsService doubleSwordsService;

    @Reference
    private DoubleSwordsService dDoubleSwordsService;

    @GetMapping("getOptimusPrimeF")
    @ApiOperation(value = "Feign-当前接口是无参数的调用",httpMethod = "GET")
    public SeibertronDTO getOptimusPrimeF() {
        SeibertronDTO seibertronDTO = null;
        try{
            seibertronDTO = this.doubleSwordsService.getOptimusPrime();
        }catch (Exception e){
        }
        return seibertronDTO;
    }

    @GetMapping("getMegatronF/{transType}")
    @ApiOperation(value = "Feign-当前接口是有参数的调用",httpMethod = "GET")
    public SeibertronDTO getMegatronF(@PathVariable("transType") String transType) {
        SeibertronDTO seibertronDTO = null;
        try{
            seibertronDTO = this.doubleSwordsService.getMegatron(transType);
        }catch (Exception e){
        }
        return seibertronDTO;
    }

    @GetMapping("getOptimusPrimeD")
    @ApiOperation(value = "Dubbo-当前接口是无参数的调用",httpMethod = "GET")
    public SeibertronDTO getOptimusPrimeD() {
        SeibertronDTO seibertronDTO = null;
        try{
            seibertronDTO = this.dDoubleSwordsService.getOptimusPrime();
        }catch (Exception e){
        }
        return seibertronDTO;
    }

    @GetMapping("getMegatronD/{transType}")
    @ApiOperation(value = "Dubbo-当前接口是有参数的调用",httpMethod = "GET")
    public SeibertronDTO getMegatronD(@PathVariable("transType") String transType) {
        SeibertronDTO seibertronDTO = null;
        try{
            seibertronDTO = this.dDoubleSwordsService.getMegatron(transType);
        }catch (Exception e){
        }
        return seibertronDTO;
    }
}