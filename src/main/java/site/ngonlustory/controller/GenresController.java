package site.ngonlustory.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import site.ngonlustory.dto.ResourceGenresDto;
import site.ngonlustory.response.ResponseMsg;
import site.ngonlustory.services.GenresService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
@Tag(name = "GenresController - Thể loại truyện")
public class GenresController {
    private final GenresService genresService;

    @Operation(
        summary = "Lấy danh sách thể loại",
        description = "Url truy cập: /api/v1/auth/getGenres?id=1&page=0&size=10&sortBy=name&direction=desc"
    )
    @GetMapping("/getGenres")
    public ResponseMsg getGenres(
            @RequestParam(required = false) Integer id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort.Direction dir = Sort.Direction.fromString(direction.toUpperCase());
        Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sortBy));
        return genresService.getGenres(id, pageable);
    }

    @PostMapping("/createGenres")
    public ResponseMsg createGenres(@RequestBody ResourceGenresDto createGenresDto) {
        return genresService.createGenres(createGenresDto, 1);
    }

    @PutMapping("/updateGenres/{id}")
    public ResponseMsg updateGenres(@PathVariable Integer id, @RequestBody ResourceGenresDto updateGenresDto) {
        return genresService.updateGenres(id, updateGenresDto);
    }

    @DeleteMapping("/deleteGenres")
    public ResponseMsg deleteGenres(@PathVariable Integer id) {
        return genresService.deleteGenres(id);
    }

}
