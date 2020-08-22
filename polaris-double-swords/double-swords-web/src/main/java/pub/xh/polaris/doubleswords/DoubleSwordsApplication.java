package pub.xh.polaris.doubleswords;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

/**
 * @Author xh
 * @Date 2020-12-07
 * @Description 启动类
 **/
@SpringBootApplication(scanBasePackages = {"pub.xh.polaris.doubleswords.*", "pub.xh.polaris.common.swagger.config"})
//@ImportResource(locations = {"classpath*:spring/spring-*.xml"})
@EnableDiscoveryClient
@EnableDubbo
@Slf4j
@RestController
class DoubleSwordsApplication implements ApplicationListener<ApplicationReadyEvent> {
    @RequestMapping("/")
    private String init() {
        return "hello double swords!";
    }

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext application = SpringApplication.run(DoubleSwordsApplication.class, args);
        Environment env = application.getEnvironment();
        log.info("\n----------------------------------------------------------\n\t" +
                        "应用 '{}' 运行成功! 访问连接:\n\t" +
                        "Swagger文档: \t\thttp://{}:{}/doc.html\n" +
                        "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        log.info("系统系统后执行");
    }
}