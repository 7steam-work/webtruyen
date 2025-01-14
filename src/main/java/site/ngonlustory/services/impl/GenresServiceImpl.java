package site.ngonlustory.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.ngonlustory.dto.ResourceGenresDto;
import site.ngonlustory.models.GenresEntity;
import site.ngonlustory.repository.GenresRepository;
import site.ngonlustory.response.ResponseMsg;
import site.ngonlustory.services.GenresService;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class GenresServiceImpl implements GenresService {
    private final GenresRepository genresRepository;


    @Override
    public ResponseMsg getGenres(Integer id, Pageable pageable) {
        if (id == null) {
            return ResponseMsg.success(genresRepository.findAll(pageable));
        } else {
            return ResponseMsg.success(genresRepository.findById(id).orElse(null));
        }
    }

    @Override
    public ResponseMsg createGenres(ResourceGenresDto input, Integer id) {
        return ResponseMsg.success(genresRepository.save(
                GenresEntity.builder()
                    .name_EN(input.getGenresNameEn())
                    .name_VN(input.getGenresNameVN())
                    .build()));
    }

    @Override
    public ResponseMsg updateGenres(Integer id, ResourceGenresDto input) {
        Optional<GenresEntity> genresOptional = genresRepository.findById(id);

        if (genresOptional.isEmpty()) {
            return ResponseMsg.error(404, "Genres not found");
        }

        GenresEntity existingGenres = genresOptional.get();

        // Chỉ update các trường không null
        if (input.getGenresNameEn() != null) {
            existingGenres.setName_EN(input.getGenresNameEn());
        }
        if (input.getGenresNameVN() != null) {
            existingGenres.setName_VN(input.getGenresNameVN());
        }

        return ResponseMsg.success(genresRepository.save(existingGenres));
    }

    @Override
    public ResponseMsg deleteGenres(int id) {
        GenresEntity existingGenres = genresRepository.findById(id).orElse(null);
        if (existingGenres == null) {
            return ResponseMsg.error(404, "Genres not found!");
        }
        genresRepository.deleteById(id);
        return ResponseMsg.success("Drop genres " + id + " success!");
    }
}
