package site.ngonlustory.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.ngonlustory.dto.ResourceChapterDto;
import site.ngonlustory.response.ResponseMsg;

import java.util.List;

@Service
public interface ChaptersService {
    ResponseMsg getChapter(Integer id, Pageable pageable);
    ResponseMsg getChapterByStoryId(Integer id, Pageable pageable);
    ResponseMsg createChapter(ResourceChapterDto resourceChapterDto, Integer id);
    ResponseMsg updateChapter(Integer id, ResourceChapterDto resourceChapterDto);
    ResponseMsg deleteChapter(Integer id);
    ResponseMsg deleteChapterByIds(List<Integer> chapterIds);
    ResponseMsg deleteChapterByStory(Integer id);
}
