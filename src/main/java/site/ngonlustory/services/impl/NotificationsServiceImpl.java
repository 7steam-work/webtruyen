package site.ngonlustory.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.ngonlustory.repository.NotificationsRepository;
import site.ngonlustory.services.NotificationsService;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationsServiceImpl implements NotificationsService {
    private final NotificationsRepository notificationsRepository;

}
