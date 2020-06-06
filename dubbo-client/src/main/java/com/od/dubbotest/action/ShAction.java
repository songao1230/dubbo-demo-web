package com.od.dubbotest.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.od.dubbotest.api.HelloService;
import java.util.logging.Level;
import java.util.logging.Logger;
@RestController
@RequestMapping(value="/sh")
public class ShAction {
	
	@Reference HelloService helloService;
	
	@RequestMapping

	public String say(String name) {
                Logger log = Logger.getLogger("com"); 
		log.log(Level.INFO, "HelloAction接收到请求:", name);
		String str = "<h1>这是Dubbo 消费者端(springboot)</h1>";
		str += "<h2>这里是上海站的页面</h2>";
                str+="<h2>这里是上海站新加入的功能，灰度测试</h2>";
		str += helloService.hello(name);
		log.log(Level.INFO, "HelloService返回到结果:", str);
		return str;
	}
}
