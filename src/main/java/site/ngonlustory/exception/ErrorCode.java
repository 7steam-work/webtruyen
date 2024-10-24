package site.ngonlustory.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    BAD_REQUEST(400, "Yêu cầu không hợp lệ!"),
    UNAUTHORIZED(401, "Bạn không có quyền truy cập! Hãy thử lại với vai trò quản trị viên."),
    UNAUTHENTICATION(403, "Xác thực thất bại!"),
    NOT_FOUND(404, "Tài nguyên không tìm thấy!"),
    CONFLICT(409, "Tài nguyên đã tồn tại!"),
    PAYLOAD_TOO_LARGE(429, "Tập tin quá lớn! Hãy thử lại với kích thước tối đa 10Mb."),
    UNSUPPORTED_MEDIA_TYPE(415, "Tập tin phải là hình ảnh!"),
    INTERNAL_SERVER_ERROR(500, "Lỗi máy chủ nội bộ!");


    private final int code;
    private final String message;

}