package com.example.demo;


import com.example.Configuration.ApplicationContextProvider;
import com.example.Configuration.MyProperties;
import com.example.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    @Autowired
    ApplicationContextProvider provider;
    @Test
    public void mytest()throws Exception{
        ApplicationContext context = provider.getApplicationContext();
        Object ob = context.getBean("testFilterRegistration");

        MyProperties properties = (MyProperties)context.getBean("myProperties");
        System.out.println(properties.getTitle());

        RedisService service = (RedisService) context.getBean("redisService");
        System.out.println(service.getClass().getName());
        service.set("user","wocao");
        Thread.sleep(10000);
        System.out.println(service.get("user"));
    }
}
