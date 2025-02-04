package site.ngonlustory.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.ngonlustory.repository.FavoritesRepository;
import site.ngonlustory.services.FavoritesService;

@Service
@Slf4j
@RequiredArgsConstructor
public class FavoritesServiceImpl implements FavoritesService {
    private final FavoritesRepository favoritesRepository;

}
