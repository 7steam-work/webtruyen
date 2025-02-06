package site.ngonlustory.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.ngonlustory.dto.ResourceStoryDto;
import site.ngonlustory.models.GenresEntity;
import site.ngonlustory.models.StoryEntity;
import site.ngonlustory.models.StoryGenresEntity;
import site.ngonlustory.repository.GenresRepository;
import site.ngonlustory.repository.StoryGenresRepository;
import site.ngonlustory.repository.StoryRepository;
import site.ngonlustory.response.ResponseMsg;
import site.ngonlustory.services.StoryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoryServiceImpl implements StoryService {
    private final StoryRepository storyRepository;
    private final StoryGenresRepository storyGenresRepository;
    private final GenresRepository genresRepository;

    @Override
    public ResponseMsg getStory(Integer id, Pageable pageable) {
        if (id == null) {
            return ResponseMsg.success(storyRepository.findAll(pageable));
        } else {
            return ResponseMsg.success(storyRepository.findById(id).orElse(null));
        }
    }

    @Override
    public ResponseMsg getStoryByGenresId(Integer idGenres, Pageable pageable) {
        if (idGenres == null) {
            return ResponseMsg.error(400, "Mã id không được trống!");
        }
        GenresEntity genresExist = genresRepository.findById(idGenres).orElse(null);
        if (genresExist == null) {
            return ResponseMsg.error(404, "Không tìm thấy thể loại truyện này!");
        }

        List<StoryGenresEntity> storyGenresEntityList = storyGenresRepository.findByGenresModel(genresExist);

        List<Integer> listStory = storyGenresEntityList.stream().map(StoryGenresEntity::getId).toList();

        return ResponseMsg.success(storyRepository.findByIdIn(listStory, pageable));
    }

    @Override
    @Transactional
    public ResponseMsg createStory(ResourceStoryDto createStoryDto, Integer genresId) {
        Optional<GenresEntity> genresOptional = genresRepository.findById(genresId);
        if (genresOptional.isEmpty()) {
            return ResponseMsg.error(404, "Khong tim thay the loai nay!");
        }
        GenresEntity existingGenres = genresOptional.get();

        StoryEntity storySaved = storyRepository.save(
                StoryEntity.builder()
                    .title(createStoryDto.getTitle())
                    .author(createStoryDto.getAuthor())
                    .description(createStoryDto.getDescription())
                    .coverImage(createStoryDto.getCoverImage())
                    .type(createStoryDto.getTypeStory())
                    .status(createStoryDto.getStatusStory())
                    .createdAt(createStoryDto.getCreatedAt())
                    .viewCount(createStoryDto.getViewCount())
                    .totalChapters(createStoryDto.getTotalChapters())
                    .lastUpdated(createStoryDto.getLastUpdated())
                    .ratingAvg(createStoryDto.getRatingAvg())
                    .totalRatings(createStoryDto.getTotalRatings())
                    .build()
        );

        storyGenresRepository.save(
            StoryGenresEntity.builder()
                .genresModel(existingGenres)
                .storyEntity(storySaved)
                .build()
        );

        return ResponseMsg.success(storySaved);
    }

    @Override
    public ResponseMsg updateStory(Integer id, ResourceStoryDto updateStoryDto) {
        Optional<StoryEntity> storyOptional = storyRepository.findById(id);

        if (storyOptional.isEmpty()) {
            return ResponseMsg.error(404, "Khong tim thay ma truyen " + id + "!");
        }

        StoryEntity existingStory = storyOptional.get();
        if (updateStoryDto.getTitle() != null) {
            existingStory.setTitle(updateStoryDto.getTitle());
        }
        if (updateStoryDto.getAuthor() != null) {
            existingStory.setAuthor(updateStoryDto.getAuthor());
        }
        if (updateStoryDto.getDescription() != null) {
            existingStory.setDescription(updateStoryDto.getDescription());
        }
        if (updateStoryDto.getCoverImage() != null) {
            existingStory.setCoverImage(updateStoryDto.getCoverImage());
        }
        if (updateStoryDto.getTypeStory() != null) {
            existingStory.setType(updateStoryDto.getTypeStory());
        }
        if (updateStoryDto.getStatusStory() != null) {
            existingStory.setStatus(updateStoryDto.getStatusStory());
        }
        if (updateStoryDto.getCreatedAt() != null) {
            existingStory.setCreatedAt(updateStoryDto.getCreatedAt());
        }
        if (updateStoryDto.getViewCount() != null) {
            existingStory.setViewCount(updateStoryDto.getViewCount());
        }
        if (updateStoryDto.getTotalChapters() != null) {
            existingStory.setTotalChapters(updateStoryDto.getTotalChapters());
        }
        if (updateStoryDto.getLastUpdated() != null) {
            existingStory.setLastUpdated(updateStoryDto.getLastUpdated());
        }
        if (updateStoryDto.getRatingAvg() != null) {
            existingStory.setRatingAvg(updateStoryDto.getRatingAvg());
        }
        if (updateStoryDto.getTotalRatings() != null) {
            existingStory.setTotalRatings(updateStoryDto.getTotalRatings());
        }

        return ResponseMsg.success(storyRepository.save(existingStory));
    }

    @Override
    @Transactional
    public ResponseMsg deleteStory(Integer id) {
        StoryGenresEntity storyGenresEntity = storyGenresRepository.findById(id).orElse(null);
        if (storyGenresEntity == null) {
            return ResponseMsg.error(404, "Khong tim thay ma truyen");
        }
        StoryEntity storyEntity = storyRepository.findById(id).orElse(null);
        if (storyEntity == null) {
            return ResponseMsg.error(404, "Khong tim thay ma truyen");
        }
        String storyName = storyEntity.getTitle();

        storyRepository.delete(storyEntity);
        storyGenresRepository.delete(storyGenresEntity);
        return ResponseMsg.success("Xóa truyện `" + storyName + "` thành công!");
    }

    @Override
    @Transactional
    public ResponseMsg deleteStoriesByIds(List<Integer> storyIds) {
        if (storyIds == null || storyIds.isEmpty()) {
            return ResponseMsg.error(400, "Danh sách ID truyện không được trống!");
        }

        List<StoryEntity> stories = storyRepository.findAllById(storyIds);
        List<Integer> foundIds = stories.stream().map(StoryEntity::getId).toList();
        List<Integer> notFoundIds = storyIds.stream()
                .filter(id -> !foundIds.contains(id))
                .toList();
        if (stories.isEmpty()) {
            return ResponseMsg.error(404, "Không tìm thấy truyện nào với danh sách ID đã nhập!");
        }
        List<StoryGenresEntity> storyGenresList = storyGenresRepository.findByStoryEntityIn(stories);
        storyGenresRepository.deleteAll(storyGenresList);

        storyRepository.deleteAll(stories);
        if (!notFoundIds.isEmpty()) {
            return ResponseMsg.success("Đã xóa " + stories.size() + " truyện thành công!"
                    + "\nĐã bỏ qua các mã truyện do không tìm thấy: " + notFoundIds);
        } else {
            return ResponseMsg.success("Đã xóa " + stories.size() + " truyện thành công!");
        }
    }

    @Override
    @Transactional
    public ResponseMsg deleteStoriesByGenre(Integer genreId) {
        if (genreId == null) {
            return ResponseMsg.error(400, "Không được trống id!");
        }
        GenresEntity genresExist = genresRepository.findById(genreId).orElse(null);
        List<StoryGenresEntity> storyGenresList = storyGenresRepository.findByGenresModel(genresExist);
        if (storyGenresList.isEmpty()) {
            return ResponseMsg.error(404, "Không có truyện nào thuộc thể loại này!");
        }
        List<Integer> storyIds = storyGenresList.stream()
                .map(storyGenres -> storyGenres.getStoryEntity().getId())
                .toList();
        storyGenresRepository.deleteAll(storyGenresList);

        storyRepository.deleteAllById(storyIds);
        return ResponseMsg.success("Đã xóa toàn bộ truyện thuộc thể loại " + genresExist.getName_VN());
    }
}
