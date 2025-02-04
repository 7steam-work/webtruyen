package site.ngonlustory.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.ngonlustory.repository.RatingChapRepository;
import site.ngonlustory.services.RatingChapService;

@Service
@Slf4j
@RequiredArgsConstructor
public class RatingChapServiceImpl implements RatingChapService {
    private final RatingChapRepository ratingChapRepository;

}
