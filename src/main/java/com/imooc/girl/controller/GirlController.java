package com.imooc.girl.controller;

import com.imooc.girl.entity.Girl;
import com.imooc.girl.entity.Result;
import com.imooc.girl.exception.GirlException;
import com.imooc.girl.repository.GirlRepository;
import com.imooc.girl.service.GirlService;
import com.imooc.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Transactional
public class GirlController {

    private Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    GirlService girlService;

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 查询出所有女生返回json字符串
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {

        logger.info("girlList started!!!");

        List<Girl> girls = girlRepository.findAll();
        return girls;
    }

    /**
     * 新增一个女生
     *
     * @return
     */
    @PostMapping(value = "/girls")
/*    @Valid  : 检查该对象内部有@Min注解的属性，
        如果发生错误，将错误信息保存在BindingResult对象中*/
    public Result girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResultUtil.error(0, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 根据id查询一个女生
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        Girl girl = girlRepository.findOne(id);
        return girl;
    }

    /**
     * 根据id值删除女生
     *
     * @param id
     */
    @DeleteMapping("/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    /**
     * 根据id更新一个女生的数据
     *
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 通过年龄查询女生列表
     *
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> findGirlByAge(
            @PathVariable(value = "age") Integer age) {
        List<Girl> girls = girlRepository.findGirlByAge(age);
        return girls;
    }

    @GetMapping(value = "/girls/addTwo")
    public List<Girl> girlAddTwo() {
        return girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws GirlException {
        girlService.getAge(id);
    }

}
