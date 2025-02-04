package site.ngonlustory.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.ngonlustory.repository.ChapterImageRepository;
import site.ngonlustory.response.ResponseMsg;
import site.ngonlustory.services.ChapterImageService;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChapterImageServiceImpl implements ChapterImageService {
    private final ChapterImageRepository genresImageRepository;

}
