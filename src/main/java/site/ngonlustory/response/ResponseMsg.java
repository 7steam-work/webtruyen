package site.ngonlustory.response;

public record ResponseMsg(Integer code, String message, Object data) {
    public static ResponseMsg success(Object data) {
        return new ResponseMsg(200, "success", data);
    }
    public static ResponseMsg success(String message, Object data) {
        return new ResponseMsg(200, message, data);
    }
    public static ResponseMsg success(Integer code, String message, Object data) {
        return new ResponseMsg(code, message, data);
    }

    public static ResponseMsg error(Integer code, String message) {
        return new ResponseMsg(code, message, null);
    }

    public int getCode() {
        return code;
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
}
