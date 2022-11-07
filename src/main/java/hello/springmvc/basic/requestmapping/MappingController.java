package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    //@RequestMapping({"/hello-basic","/hello-go"})
    //배열 값으로 써서 두 개의 url mapping도 가능하다!
    @RequestMapping("/hello-basic")
    public String helloBasci() {
        log.info("hellobasic");
        return "ok";
    }
}