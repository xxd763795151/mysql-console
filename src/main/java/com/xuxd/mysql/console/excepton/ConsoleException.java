package com.xuxd.mysql.console.excepton;

/**
 * @Auther: 许晓东
 * @Date: 18-7-17 16:44
 * @Description:
 */
public class ConsoleException extends RuntimeException {

    protected String code;
    protected String message;
    protected Throwable cause;

    public ConsoleException() {
        super();
    }

    public ConsoleException(String message) {
        super(message);
        this.message = message;
    }

    public ConsoleException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ConsoleException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public String toString() {
        return "ConsoleException{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String toJsonString() {
        return "{\"returnCode\":\"" + code + "\",\"returnMessage\":\"" + message + "\"}";
    }
}
