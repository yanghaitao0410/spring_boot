package com.imooc.girl.service;

import com.imooc.girl.entity.Girl;
import com.imooc.girl.entity.Result;
import com.imooc.girl.enums.ExceptionEnum;
import com.imooc.girl.exception.GirlException;
import com.imooc.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public List<Girl> insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);

        Girl girlB = new Girl();
        girlB.setCupSize("BBBB");
        girlB.setAge(19);
        List<Girl> girls = new ArrayList<Girl>();

        girls.add(girlRepository.save(girlA));
        girls.add(girlRepository.save(girlB));
        return girls;
    }

    public void getAge(Integer id) throws GirlException{
        Girl girl = girlRepository.findOne(id);
        if(girl.getAge() < 12){
            throw new GirlException(ExceptionEnum.PRIMARY_SCHOOL);
        }else if(girl.getAge() > 12 && girl.getAge() < 16){
            throw new GirlException(ExceptionEnum.MIDDLE_SCHOOL);
        }


    }
}
