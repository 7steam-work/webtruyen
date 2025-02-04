package site.ngonlustory.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.ngonlustory.repository.ChaptersRepository;
import site.ngonlustory.services.ChaptersService;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChaptersService {
    private final ChaptersRepository chaptersRepository;

}
