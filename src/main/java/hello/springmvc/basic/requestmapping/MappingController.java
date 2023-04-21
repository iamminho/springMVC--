package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    //@RequestMapping("/hello-basic")
    @GetMapping("/mapping-get-v2")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    /**
     * PathVariable(경로변수) 사용
     * 변수명이 같으면 샹략 가능
     *
     * @PathVariable("userId") String userId -> @PathVariable userId
     * /mapping/userA
     */
    @GetMapping("/mapping/{userId}")
    // public String mappingPath(@PathVariable("userId") String data) {
    public String mappingPath(@PathVariable String userId) {
        log.info("mappingPath userId = {}", userId);
        return "ok";
    }

    /**
     * 파라미터 추가로 매핑
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    // public String mappingPath(@PathVariable("userId") String data) {
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId = {}, orderId = {}", userId, orderId);
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    // MediaType.APPLICATION_JSON_VALUE -> "application/json"
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type * produces = "text/html"
     * produces = "!text/html"
     * }
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    // MediaType.TEXT_HTML_VALUE -> "text/html"
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}