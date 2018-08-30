package com.lljr.loan.exception;

import com.lljr.loan.common.CommonResponse;
import com.lljr.loan.common.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 * @author tianhuan
 * @date 2017-08-02 11:44
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)
    public void defaultExceptionHandle(HttpServletRequest req, Exception e){
        logger.error(e.getMessage(),e);
        logger.info("url:{}",req.getRequestURL());
    }

    /**
     * 自定义异常全局处理
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public CommonResponse<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        CommonResponse<String> r = new CommonResponse<>();
        r.setMessage(e.getMessage());
        r.setCode(ResponseCode.INTERNAL_SERVER_ERROR.getCode());
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());
        logger.info("my error");
        return r;
    }
}
