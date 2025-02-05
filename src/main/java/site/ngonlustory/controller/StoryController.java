package site.ngonlustory.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import site.ngonlustory.dto.ResourceStoryDto;
import site.ngonlustory.response.ResponseMsg;
import site.ngonlustory.services.StoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
@Tag(name = "StoryController - Đầu truyện")
public class StoryController {
    private final StoryService storyService;

    @Operation(summary = "Lấy danh sách các truyện bằng mã truyện", description = "Url truy cập: /api/v1/auth/getStory?id=1&page=0&size=10&sortBy=name&direction=desc")
    @GetMapping("/getStory")
    public ResponseMsg getStory(
            @RequestParam(required = false) Integer id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort.Direction dir = Sort.Direction.fromString(direction.toUpperCase());
        Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sortBy));
        return storyService.getStory(id, pageable);
    }

    @Operation(summary = "Lấy danh sách các truyện bằng mã thể loại", description = "Url truy cập: /api/v1/auth/getStory?id=1&page=0&size=10&sortBy=name&direction=desc")
    @GetMapping("/getStoryByGenres")
    public ResponseMsg getStoryByGenresId(
            @RequestParam(required = false) Integer idGenres,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort.Direction dir = Sort.Direction.fromString(direction.toUpperCase());
        Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sortBy));
        return storyService.getStoryByGenresId(idGenres, pageable);
    }

    @PostMapping("/createStory")
    public ResponseMsg createStory(@RequestBody ResourceStoryDto createStoryDto, Integer genresId) {
        return storyService.createStory(createStoryDto, genresId);
    }

    @PutMapping("/updateStory/{id}")
    public ResponseMsg updateStory(@PathVariable Integer id, @RequestBody ResourceStoryDto updateStoryDto) {
        return storyService.updateStory(id, updateStoryDto);
    }

    @Operation(summary = "Xóa 1 truyện bằng mã truyện", description = "Input: 1 mã truyện (int) \n Output: xóa 1 truyện")
    @DeleteMapping("/deleteStory")
    public ResponseMsg deleteStory(@PathVariable Integer id) {
        return storyService.deleteStory(id);
    }

    @Operation(summary = "Xóa danh sách truyện theo danh sách ID", description = "Input: danh sách mã truyện (List<Integer>) \n Output: xóa nhiều truyện")
    @DeleteMapping("/deleteStoriesByIds")
    public ResponseMsg deleteStoriesByIds(@RequestBody List<Integer> storyIds) {
        return storyService.deleteStoriesByIds(storyIds);
    }

    @Operation(summary = "Xóa toàn bộ truyện theo mã thể loại", description = "Input: 1 mã thể loại (int) \n Output: xóa toàn bộ truyện ở thể loại này")
    @DeleteMapping("/deleteStoryByGenre/{genreId}")
    public ResponseMsg deleteStoriesByGenre(@PathVariable Integer genreId) {
        return storyService.deleteStoriesByGenre(genreId);
    }




}
