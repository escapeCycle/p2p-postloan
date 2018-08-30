package com.lljr.loan.common;

import lombok.*;

/**
 *
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {

    private int code;
    private String message;
    private String url;
    private T data;

}
