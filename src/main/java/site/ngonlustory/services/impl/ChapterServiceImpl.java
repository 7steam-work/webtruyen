package site.ngonlustory.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.ngonlustory.dto.ResourceChapterDto;
import site.ngonlustory.models.ChapterEntity;
import site.ngonlustory.models.GenresEntity;
import site.ngonlustory.models.StoryEntity;
import site.ngonlustory.models.StoryGenresEntity;
import site.ngonlustory.repository.ChaptersRepository;
import site.ngonlustory.repository.StoryRepository;
import site.ngonlustory.response.ResponseMsg;
import site.ngonlustory.services.BaseService;
import site.ngonlustory.services.ChaptersService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChaptersService {
    private final ChaptersRepository chaptersRepository;
    private final StoryRepository storyRepository;
    private final BaseService baseService;

    @Override
    public ResponseMsg getChapter(Integer id, Pageable pageable) {
        if (id == null) {
            return ResponseMsg.success(chaptersRepository.findAll(pageable));
        } else {
            return ResponseMsg.success(chaptersRepository.findById(id).orElse(null));
        }
    }

    @Override
    public ResponseMsg getChapterByStoryId(Integer storyId, Pageable pageable) {
        if (storyId == null) {
            return ResponseMsg.success(storyRepository.findAll(pageable));
        }
        StoryEntity storyExist = storyRepository.findById(storyId).orElse(null);
        if (storyExist == null) {
            return ResponseMsg.error(404, "Không tìm thấy thể loại truyện này!");
        }

        List<ChapterEntity> listChapter = chaptersRepository.findByStoryEntity(storyExist, pageable);

        return ResponseMsg.success(listChapter);
    }

    @Override
    public ResponseMsg createChapter(ResourceChapterDto resourceChapterDto, Integer id) {
        StoryEntity storyExist = storyRepository.findById(id).orElse(null);
        if (storyExist == null) {
            return ResponseMsg.error(404, "Khong tim thay ma truyen");
        } else {
            return ResponseMsg.success(chaptersRepository.save(
                    ChapterEntity.builder()
                            .storyEntity(storyExist)
                            .chapterNumber(Integer.valueOf(resourceChapterDto.getChapterNumber()))
                            .title(resourceChapterDto.getTitle())
                            .content(resourceChapterDto.getContent())
                            .createdAt(resourceChapterDto.getCreatedAt())
                            .build()));
        }
    }

    @Override
    public ResponseMsg updateChapter(Integer id, ResourceChapterDto input) {
        if (id == null) {
            return ResponseMsg.error(400, "Id truyen bi rong");
        }
        Optional<ChapterEntity> chapterExist = chaptersRepository.findById(id);
        if (chapterExist.isEmpty()) {
            return ResponseMsg.error(404, "Khong tim thay ma truyen " + id);
        }

        ChapterEntity newChapter = chapterExist.get();
        if (input.getChapterNumber() != null) {
            newChapter.setChapterNumber(Integer.valueOf(input.getChapterNumber()));
        }
        if (input.getContent() != null) {
            newChapter.setContent(input.getContent());
        }
        if (input.getTitle() != null) {
            newChapter.setTitle(input.getTitle());
        }
        if (input.getCreatedAt() != null) {
            newChapter.setCreatedAt(input.getCreatedAt());
        }

        return ResponseMsg.success(chaptersRepository.save(newChapter));
    }

    @Override
    public ResponseMsg deleteChapter(Integer id) {
        return baseService.deleteEntityById(chaptersRepository, id, "Chapter");

    }

    @Override
    @Transactional
    public ResponseMsg deleteChapterByIds(List<Integer> chapterIds) {
        if (chapterIds == null || chapterIds.isEmpty()) {
            return ResponseMsg.error(400, "Danh sách mã chapter không được trống!");
        }

        List<ChapterEntity> chapter = chaptersRepository.findAllById(chapterIds);
        List<Integer> foundIds = chapter.stream().map(ChapterEntity::getId).toList();
        List<Integer> notFoundIds = chapterIds.stream()
                .filter(id -> !foundIds.contains(id))
                .toList();
        if (chapter.isEmpty()) {
            return ResponseMsg.error(404, "Không tìm thấy truyện nào với danh sách ID đã nhập!");
        }
        chaptersRepository.deleteAll(chapter);
        if (!notFoundIds.isEmpty()) {
            return ResponseMsg.success("Đã xóa " + chapter.size() + " truyện thành công!"
                    + "\nĐã bỏ qua các mã truyện do không tìm thấy: " + notFoundIds);
        } else {
            return ResponseMsg.success("Đã xóa " + chapter.size() + " truyện thành công!");
        }
    }

    @Override
    @Transactional
    public ResponseMsg deleteChapterByStory(Integer id) {
        if (id == null) {
            return ResponseMsg.error(400, "Mã truyện không được để trống!");
        }

        StoryEntity story = storyRepository.findById(id).orElse(null);
        if (story == null) {
            return ResponseMsg.error(404, "Không tìm thấy truyện với mã " + id);
        }

        List<ChapterEntity> chapters = chaptersRepository.findByStoryEntity(story);
        if (chapters.isEmpty()) {
            return ResponseMsg.error(404, "Không tìm thấy chapter nào của truyện này!");
        }

        chaptersRepository.deleteAll(chapters);
        return ResponseMsg.success("Đã xóa " + chapters.size() + " chapter của truyện thành công!");
    }
}
