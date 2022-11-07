package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController을 기재하는 이유
//@Controller을 기재하게 되면 return 값이 view 이름이 반환된다.
//@RestController을 반환 값은 String 자체가 반환 된다.
//@Slf4j lombok이 지원한다.
@Slf4j
@RestController
public class LogTestController {
    //내 class 지정
    //getClass() 대신 LogTestController.class로 기재해도 됨
    //private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        //2022-11-07 13:44:27.704  INFO 4944 --- [nio-8080-exec-2] hello.springmvc.basic.LogTestController  :  info log=Spring
        //시간 , 로그 레벨 , 쓰레드 (nio-8080-exec-2] , 실행한 class 같은 여러가지가 같이 찍힌다
        log.trace("trace log={}", name);
        //디버그 할 때 쓰임
        log.debug("debug log={}", name);
        //경고
        log.warn("warn log={}", name);
        log.info(" info log={}", name);
        log.error("error log={}", name);

        return "ok";

    }
}
