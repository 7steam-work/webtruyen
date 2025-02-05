package site.ngonlustory.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.ngonlustory.dto.ResourceStoryDto;
import site.ngonlustory.response.ResponseMsg;

import java.util.List;

@Service
public interface StoryService {
    ResponseMsg getStory(Integer id, Pageable pageable);
    ResponseMsg getStoryByGenresId(Integer idGenres, Pageable pageable);
    ResponseMsg createStory(ResourceStoryDto createStoryDto, Integer genresId);
    ResponseMsg updateStory(Integer id, ResourceStoryDto updateStoryDto);
    ResponseMsg deleteStory(Integer id);
    ResponseMsg deleteStoriesByIds(List<Integer> storyIds);
    ResponseMsg deleteStoriesByGenre(Integer id);
}
