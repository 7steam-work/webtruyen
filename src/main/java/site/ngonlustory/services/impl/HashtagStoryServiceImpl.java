package site.ngonlustory.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.ngonlustory.repository.HashtagStoryRepository;
import site.ngonlustory.services.HashtagStoryService;

@Service
@Slf4j
@RequiredArgsConstructor
public class HashtagStoryServiceImpl implements HashtagStoryService {
    private final HashtagStoryRepository hashtagStoryRepository;

}
