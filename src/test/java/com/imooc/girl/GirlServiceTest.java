package com.imooc.girl;

import com.imooc.girl.entity.Girl;
import com.imooc.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//指明该类要在spring容器中运行
@RunWith(SpringRunner.class)
//指明该类为spring boot测试类
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(12);
        Assert.assertEquals(new Integer(14), girl.getAge());
    }
}
