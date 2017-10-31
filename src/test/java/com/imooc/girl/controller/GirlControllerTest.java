package com.imooc.girl.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
//自动装配MockMvc
@AutoConfigureMockMvc
public class GirlControllerTest {
    /**
     * 测试通过url路径请求controller获取女生列表
     * @throws Exception
     */
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void girlList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/girls"))
                .andExpect(MockMvcResultMatchers.status().isOk()) //判断状态码是否为200
                .andExpect(MockMvcResultMatchers.content().string("abc")); //对获取的内容进行判断(当前的判断是错误的)
    }

}