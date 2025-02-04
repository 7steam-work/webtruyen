package site.ngonlustory.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.ngonlustory.repository.ReadingHistoryRepository;
import site.ngonlustory.services.ReadingHistoryService;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReadingHistoryServiceImpl implements ReadingHistoryService {
    private final ReadingHistoryRepository readingHistoryRepository;

}
