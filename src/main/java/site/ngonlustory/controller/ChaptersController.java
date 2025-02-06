package site.ngonlustory.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import site.ngonlustory.dto.ResourceChapterDto;
import site.ngonlustory.response.ResponseMsg;
import site.ngonlustory.services.ChaptersService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
@Tag(name = "ChaptersController - Tập truyện")
public class ChaptersController {
    private final ChaptersService chaptersService;

    @Operation(
        summary = "Lấy danh sách tập truyện",
        description = "Url truy cập: /api/v1/auth/getChapter?id=1&page=0&size=10&sortBy=name&direction=desc"
    )
    @GetMapping("/getChapter")
    public ResponseMsg getChapter(
            @RequestParam(required = false) Integer id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort.Direction dir = Sort.Direction.fromString(direction.toUpperCase());
        Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sortBy));
        return chaptersService.getChapter(id, pageable);
    }

    @Operation(summary = "Lấy danh sách các tập bằng mã truyện", description = "Url truy cập: /api/v1/auth/getChapterByStory?storyId=1&page=0&size=10&sortBy=name&direction=desc")
    @GetMapping("/getChapterByStory")
    public ResponseMsg getChapterByStoryId(
            @RequestParam(required = false) Integer storyId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort.Direction dir = Sort.Direction.fromString(direction.toUpperCase());
        Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sortBy));
        return chaptersService.getChapterByStoryId(storyId, pageable);
    }

    @PostMapping("/createChapter")
    public ResponseMsg createChapter(@RequestBody ResourceChapterDto createChapterDto) {
        return chaptersService.createChapter(createChapterDto, 1);
    }

    @PutMapping("/updateChapter/{id}")
    public ResponseMsg updateChapter(@PathVariable Integer id, @RequestBody ResourceChapterDto updateChapterDto) {
        return chaptersService.updateChapter(id, updateChapterDto);
    }

    @Operation(summary = "Xóa 1 tập bằng mã tập", description = "Input: 1 mã truyện (int) \n Output: xóa 1 truyện")
    @DeleteMapping("/deleteChapter")
    public ResponseMsg deleteChapter(@PathVariable Integer id) {
        return chaptersService.deleteChapter(id);
    }

    @Operation(summary = "Xóa danh sách tập theo danh sách ID", description = "Input: danh sách mã tập (List<Integer>) \n Output: xóa nhiều tập")
    @DeleteMapping("/deleteChapterByIds")
    public ResponseMsg deleteStoriesByIds(@RequestBody List<Integer> storyIds) {
        return chaptersService.deleteChapterByIds(storyIds);
    }

    @Operation(summary = "Xóa toàn bộ tập theo mã đầu truyện", description = "Input: 1 mã đầu truyện (int) \n Output: xóa toàn bộ tập ở đầu truyện này")
    @DeleteMapping("/deleteChapterByStory/{genreId}")
    public ResponseMsg deleteStoriesByStory(@PathVariable Integer genreId) {
        return chaptersService.deleteChapterByStory(genreId);
    }

}
