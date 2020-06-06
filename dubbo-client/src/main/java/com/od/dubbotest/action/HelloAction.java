package com.od.dubbotest.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.od.dubbotest.api.HelloService;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.logging.*;

@RestController
@RequestMapping(value="/hello")
public class HelloAction {
	
	@Reference HelloService helloService;
	
	@RequestMapping
	public String say(String name) {
                Logger log = Logger.getLogger("com");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		String ds = df.format(new Date());
                log.info(ds + "HelloAction接收到请求:" + name);
		String str = ds + "<h1>这是Dubbo 消费者端(Apollo)</h1><h2>o(*￣︶￣*)o欢迎来到老男孩教育K8S容器云架构师专题课1期。</h2>";
		str+=helloService.hello(name);
                log.info(ds + "HelloService返回到结果:" + str);
		return str;
	}
}
