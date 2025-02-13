package site.ngonlustory.response;

public class ResponseMsg {
    private final Integer code;
    private final String message;
    private final Object data;

    public ResponseMsg(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseMsg success(Object data) {
        return new ResponseMsg(200, "success", data);
    }

    public static ResponseMsg success(String message, Object data) {
        return new ResponseMsg(200, message, data);
    }

    public static ResponseMsg badRequest(String message) {
        return new ResponseMsg(400, message, null);
    }

    public static ResponseMsg notFound(String message) {
        return new ResponseMsg(404, message, null);
    }

    public static ResponseMsg serverError(String message) {
        return new ResponseMsg(500, message, null);
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
