package uz.pdp.g34springbootjpa.error;

public enum ErrorCode {
    USER_NOT_FOUND(404);
    public final int statusCode;

    ErrorCode(int code) {
        this.statusCode = code;
    }
}
