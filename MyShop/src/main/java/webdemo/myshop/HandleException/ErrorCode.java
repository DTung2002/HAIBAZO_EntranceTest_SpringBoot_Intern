package webdemo.myshop.HandleException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ErrorCode {
    PRODUCT_NOT_FOUND(404,"product not found"),
    CATEGORY_NOT_FOUND(404,"category not found"),
    ORDER_NOT_FOUND(404,"order not found"),
    PRODUCT_ALREADY_EXISTS(409,"product already exists"),
    CATEGORY_ALREADY_EXISTS(409,"category already exists"),
    ;
    public int errorCode;
    public String errorMessage;
}
