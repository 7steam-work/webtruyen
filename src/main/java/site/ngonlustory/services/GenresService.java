package site.ngonlustory.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.ngonlustory.dto.ResourceGenresDto;
import site.ngonlustory.response.ResponseMsg;

@Service
public interface GenresService {
    ResponseMsg getGenres(Integer id, Pageable pageable);
    ResponseMsg createGenres(ResourceGenresDto resourceGenresDto, Integer id);
    ResponseMsg updateGenres(Integer id, ResourceGenresDto resourceGenresDto);
    ResponseMsg deleteGenres(int id);
}
