package com.kamilisler.rest.websevices.restfullwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //@RequestMapping(method = RequestMethod.GET,path = "/hello-world") annotation
    // gereksiz import kaldırma : ctrl+shift+o
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello Restfull web services training!222";
    }

    @GetMapping(path = "/first-bean")
    public HelloWorldBean firstBean(){
        return new HelloWorldBean("this is my first bean");
    }
    @GetMapping(path = "/first-bean/{name}")
    public HelloWorldBean firstBeanWithPathVariable(@PathVariable String name){
        return new HelloWorldBean("Hello, this is my first bean with variable . My name is : "+ name);
    }
}
