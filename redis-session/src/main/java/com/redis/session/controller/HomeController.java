package com.redis.session.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jianfeng[mailjianfeng@163.com]
 */
@RestController
@RequestMapping(value = "/api/v1")
@PropertySource("classpath:application.properties")
public class HomeController {

    @Value("${server.port}")
    public String port;

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public Object firstResp(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("url", request.getRequestURL());
        map.put("url", request.getRequestURL());
        map.put("port",port);
        return map;
    }

    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
    public Object sessions (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("message", request.getSession().getAttribute("url"));
        map.put("port",port);
        return map;
    }

}
