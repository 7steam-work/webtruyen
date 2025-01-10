package site.ngonlustory.response;
import lombok.Getter;

public record ResponseMsg(Integer code, String message, Object data) {
    public static ResponseMsg success(Object data) {
        return new ResponseMsg(200, "success", data);
    }
    public static ResponseMsg success(String message, Object data) {
        return new ResponseMsg(200, message, data);
    }

    public static ResponseMsg error(Integer code, String message) {
        return new ResponseMsg(code, message, null);
    }

    public int getCode() {
        return code;
    }
}
