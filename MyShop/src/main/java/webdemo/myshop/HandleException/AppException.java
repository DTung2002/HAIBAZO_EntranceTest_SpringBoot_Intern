package webdemo.myshop.HandleException;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException{
    public AppException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }
    private final ErrorCode errorCode;
}