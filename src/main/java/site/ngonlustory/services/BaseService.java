package site.ngonlustory.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import site.ngonlustory.response.ResponseMsg;

import java.util.Optional;

@Service
public class BaseService {

    public <T, ID> ResponseMsg deleteEntityById(JpaRepository<T, ID> repository, ID id, String entityName) {
        Optional<T> entity = repository.findById(id);
        if (entity.isEmpty()) {
            return ResponseMsg.error(404, entityName + " không tồn tại với ID: " + id);
        }
        repository.deleteById(id);
        return ResponseMsg.success("Xóa " + entityName + " có ID: " + id + " thành công!");
    }
}
