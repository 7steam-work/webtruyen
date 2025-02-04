package site.ngonlustory.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.ngonlustory.repository.RatingStoryRepository;
import site.ngonlustory.services.RatingStoryService;

@Service
@Slf4j
@RequiredArgsConstructor
public class RatingStoryServiceImpl implements RatingStoryService {
    private final RatingStoryRepository ratingStoryRepository;

}
