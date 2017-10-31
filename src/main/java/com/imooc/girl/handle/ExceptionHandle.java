package com.imooc.girl.handle;

import com.imooc.girl.entity.Result;
import com.imooc.girl.enums.ExceptionEnum;
import com.imooc.girl.exception.GirlException;
import com.imooc.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    public final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    //声明捕获那种异常
    //返回的数据跟正常的Controller中的类似
    /*
        ModelAndView对象
        Model对象
        Map对象
        View对象
        String对象
        还有@ResponseBody、HttpEntity<?>或ResponseEntity<?>，以及void
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            logger.info("【系统异常】{}", e);
            return ResultUtil.error(
                    ExceptionEnum.UNKNOW_ERROR.getCode(), ExceptionEnum.UNKNOW_ERROR.getMessage());
        }
    }


}
