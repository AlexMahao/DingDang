package com.spearbothy.dingdang.common.exceptionhandler;


import com.spearbothy.dingdang.common.response.Result;
import com.spearbothy.dingdang.common.response.ResultCode;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: JackWenbo
 * @Date: 2018/10/11 12:00
 * @Description:
 * @Version 1.0
 */

@ControllerAdvice
public class GlobalDefultExceptionHandler {
    /**
     * 传入参数错误异常处理
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = {ParamsException.class, MethodArgumentTypeMismatchException.class, MissingServletRequestParameterException.class})
    @ResponseBody
    public Result<String> defaultParamsErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        Result<String> result = new Result<>();
        result.setResultCode(ResultCode.ERROR_REQUEST_PARAMS);
        return result;
    }

    /**
     * 业务异常
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = BussinessException.class)
    @ResponseBody
    public Result<String> defaultBaseErrorHandler(HttpServletRequest req, BussinessException e) throws Exception {
        Result<String> result = new Result<>();
        result.setResultCode(ResultCode.ERROR_BUSSINESS);
        if (!StringUtils.isEmpty(e.getMessage())) {
            result.setMessage(e.getMessage());
        }
        e.printStackTrace();
        return result;
    }


    /**
     * 默认异常处理
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<String> defultBaseErrorHandler(HttpServletRequest request, BussinessException e) {
        Result<String> result = new Result<>();
        result.setResultCode(ResultCode.ERROR_BUSSINESS);
        if (!StringUtils.isEmpty(e.getMessage())) {
            result.setMessage(e.getMessage());
        }
        e.printStackTrace();
        return result;
    }
}
