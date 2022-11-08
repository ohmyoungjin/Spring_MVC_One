package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={} age ={} ", username,  age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {

        log.info("username={} , age={}", memberName, memberAge);
        //@Controller면서 return을 String으로 주게 되면 View의 논리적 이름을 반환하게 된다.
        //이를 방지하기 위해 @ResponseBody를 적어준다
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {
        //요청 파라미터와 이름이 같게 되면 @RequestParam("xx") 생략이 가능하다.
        log.info("username={} , age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        //요청 파라미터와 이름이 같게 되면 @RequestParam("xx") 생략이 가능하다.
        //단순 타입 (String, int , Integer) 등의 타입이면 @RequestParam
        log.info("username={} , age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age) {

        //@RequestParam(required = true)로 설정돼있으면 해당 파라미터가 무조건 들어와야한다.
        //@RequestParam(required = true)가 default 형이다
        //@RequestParam(required = false)를 int 형에 쓰고 싶으면 Integer로 써야한다.
        //왜=> int = null이 될 수 없으므로 객체형인 Integer를 써줘야 한다.
        log.info("username={} , age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(defaultValue = "guest") String username,
            @RequestParam(defaultValue = "-1") int age) {

        //@Requestparam(defaultValue)를 적용하게 되면 값이 안넘어오면 정의해놓은 값으로 바꿔준다
        //@Requestparam(defaultValue)를 적용할 때는 굳이 required를 설정할 필요가 없다
        //@Requestparam(defaultValue)는 빈문자("")값이 들어와도 처리해준다.
        log.info("username={} , age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(
            @RequestParam Map<String, Object> paramMap) {

        //@Requestparam(defaultValue)를 적용하게 되면 값이 안넘어오면 정의해놓은 값으로 바꿔준다
        //@Requestparam(defaultValue)를 적용할 때는 굳이 required를 설정할 필요가 없다
        //@Requestparam(defaultValue)는 빈문자("")값이 들어와도 처리해준다.
        log.info("username={} , age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-multimap")
    public String requestParamMultiMap(
            @RequestParam MultiValueMap<String, Object> paramMap) {

        List<Object> paramList = paramMap.get("username");
        for(Object value : paramList){
            log.info("username={} ", value);
        }
        log.info("age={}", paramMap.get("age"));
        return "ok";
    }

}
