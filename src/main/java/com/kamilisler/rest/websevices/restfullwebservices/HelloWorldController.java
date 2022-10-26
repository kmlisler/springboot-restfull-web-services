package com.kamilisler.rest.websevices.restfullwebservices;

import org.springframework.web.bind.annotation.GetMapping;
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
}
