package com.imooc.girl.controller;

import com.imooc.girl.Properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
//@Controller
public class HelloController {


//    @Resource
    @Autowired
    private GirlProperties girlProperties;

   /* @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;*/

//    @RequestMapping(value = "hello/{id}", method = RequestMethod.GET)
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String say(@PathVariable(value = "id") Integer id) {
    @GetMapping("hello")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
//        return "Hello Spring boot !!!";
//        return cupSize + "," + age;
//        return content;
//        return girlProperties.getCupSize() + " ," + girlProperties.getAge();
//        return "index";
        return "id: " + id;
    }


}
