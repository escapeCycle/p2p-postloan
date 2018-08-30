package com.lljr.loan.common;

import com.lljr.loan.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tianhuan
 * @date 2018-08-30 17:08
 **/
@Slf4j
public class ResponseUtil {
    /**
     * return response with default success or error message by status
     *
     * @param resultStatus
     * @return
     */
    public static CommonResponse generateResponse(boolean resultStatus) {
        CommonResponse commonResponse;
        if (resultStatus) {
            commonResponse = CommonResponse.builder()
                    .code(ResponseCode.SUCCESS.getCode())
                    .message(CommonConstant.DEFAULT_SUCCESS_MESSAGE).build();
        } else {
            commonResponse = CommonResponse.builder()
                    .code(ResponseCode.FAIL.getCode())
                    .message(CommonConstant.DEFAULT_FAIL_MESSAGE).build();
        }
        return commonResponse;
    }

    /**
     * return response with custom message by status
     *
     * @param message
     * @param resultStatus
     * @return
     */
    public static CommonResponse generateResponse(String message, boolean resultStatus) {
        CommonResponse commonResponse;
        if (resultStatus) {
            commonResponse = CommonResponse.builder()
                    .code(ResponseCode.SUCCESS.getCode())
                    .message(message).build();
        } else {
            commonResponse = CommonResponse.builder()
                    .code(ResponseCode.FAIL.getCode())
                    .message(message).build();
        }
        return commonResponse;
    }

    /**
     * return response with data,if data is null,return no data message,or return data
     *
     * @param data
     * @return
     */
    public static CommonResponse generateResponse(Object data) {
        CommonResponse commonResponse ;
        if (data != null) {
            commonResponse = CommonResponse.builder()
                    .code(ResponseCode.SUCCESS.getCode())
                    .message(CommonConstant.DEFAULT_SUCCESS_MESSAGE)
                    .data(data).build();
        } else {
            commonResponse = CommonResponse.builder()
                    .code(ResponseCode.SUCCESS.getCode())
                    .message(CommonConstant.NO_RESULT_MESSAGE).build();

        }
        return commonResponse;
    }

    /**
     * Handler response information
     *
     * @param response
     * @param object
     * @return
     */
    public static HttpServletResponse handlerResponse(HttpServletResponse response, Object object) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JsonUtils.toJson(object));
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }
        return response;
    }
}
