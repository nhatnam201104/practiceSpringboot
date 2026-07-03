package com.example.backend.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    SUCCESS("SUCCESS", HttpStatus.OK, "Thành công"),
    INTERNAL_ERROR("INTERNAL_ERROR", HttpStatus.INTERNAL_SERVER_ERROR, "Lỗi hệ thống"),
    VALIDATION_ERROR("VALIDATION_ERROR", HttpStatus.BAD_REQUEST, "Dữ liệu không hợp lệ"),
    UNAUTHORIZED("UNAUTHORIZED", HttpStatus.UNAUTHORIZED, "Chưa xác thực"),
    ACCESS_DENIED("ACCESS_DENIED", HttpStatus.FORBIDDEN, "Không có quyền truy cập"),
    NOT_FOUND("NOT_FOUND", HttpStatus.NOT_FOUND, "Không tìm thấy tài nguyên"),
    BAD_REQUEST("BAD_REQUEST", HttpStatus.BAD_REQUEST, "Yêu cầu không hợp lệ");

    private final String code;
    private final HttpStatus httpStatus;
    private final String defaultMessage;

    ErrorCode(String code, HttpStatus httpStatus, String defaultMessage) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.defaultMessage = defaultMessage;
    }
}
