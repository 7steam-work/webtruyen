package site.ngonlustory.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.ngonlustory.repository.StoryGenresRepository;
import site.ngonlustory.services.StoryGenresService;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoryGenresServiceImpl implements StoryGenresService {
    private final StoryGenresRepository storyGenresRepository;

}
