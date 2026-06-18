package com.post.ms.post.service.impl;

import com.post.ms.post.client.external.MetaFeedResponse;
import com.post.ms.post.dto.response.PostInfoResponse;
import com.post.ms.post.client.MetaFeignClient;
import com.post.ms.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static com.post.ms.post.mapper.MetaMapper.META_MAPPER;
import static com.post.ms.post.util.ApplicationConstants.FIELD_FOR_POST_INFO;
import static com.post.ms.post.util.ApplicationConstants.POST_LIMIT;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final MetaFeignClient metaFeignClient;

    @Override
    public List<PostInfoResponse> getLimitedPosts() {
        MetaFeedResponse feed = metaFeignClient.getFeed(FIELD_FOR_POST_INFO, POST_LIMIT);
        return META_MAPPER.toPostResponse(feed.data());


//
//        List<PostInfoResponse> mockPosts = List.of(
//                PostInfoResponse.builder()
//                        .id("post_001")
//                        .message("Разбор архитектурных паттернов в Java.")
//                        .createdTime("2026-06-18T08:00:00Z")
//                        .commentTotalCount(15)
//                        .reactionTotalCount(120)
//                        .engagement(135)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_002")
//                        .message("Почему не стоит бояться переходить на новые версии JDK.")
//                        .createdTime("2026-06-18T08:30:00Z")
//                        .commentTotalCount(42)
//                        .reactionTotalCount(310)
//                        .engagement(352)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_003")
//                        .message("Шпаргалка по работе с Stream API.")
//                        .createdTime("2026-06-18T09:15:00Z")
//                        .commentTotalCount(8)
//                        .reactionTotalCount(95)
//                        .engagement(103)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_004")
//                        .message("Как настроить CI/CD пайплайн за 10 минут.")
//                        .createdTime("2026-06-18T10:00:00Z")
//                        .commentTotalCount(23)
//                        .reactionTotalCount(140)
//                        .engagement(163)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_005")
//                        .message("Вышел новый релиз Spring Boot! Обсуждаем фичи.")
//                        .createdTime("2026-06-18T11:00:00Z")
//                        .commentTotalCount(31)
//                        .reactionTotalCount(185)
//                        .engagement(216)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_006")
//                        .message("Утренняя кофе-пауза. Какую IDE вы предпочитаете?")
//                        .createdTime("2026-06-18T11:20:00Z")
//                        .commentTotalCount(54)
//                        .reactionTotalCount(92)
//                        .engagement(146)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_007")
//                        .message("Напоминание: сегодня тех. работы на сервере в 23:00.")
//                        .createdTime("2026-06-18T12:00:00Z")
//                        .commentTotalCount(4)
//                        .reactionTotalCount(18)
//                        .engagement(22)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_008")
//                        .message("Наша команда ищет Senior Java Developer. Пишите в ЛС.")
//                        .createdTime("2026-06-18T12:45:00Z")
//                        .commentTotalCount(12)
//                        .reactionTotalCount(64)
//                        .engagement(76)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_009")
//                        .message("10 скрытых фич IntelliJ IDEA, о которых вы не знали.")
//                        .createdTime("2026-06-18T13:10:00Z")
//                        .commentTotalCount(89)
//                        .reactionTotalCount(620)
//                        .engagement(709)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_010")
//                        .message("Мемы про деплой в пятницу вечером. Листайте карусель.")
//                        .createdTime("2026-06-18T14:00:00Z")
//                        .commentTotalCount(156)
//                        .reactionTotalCount(1240)
//                        .engagement(1396)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_011")
//                        .message("Разница между SQL и NoSQL на простых примерах.")
//                        .createdTime("2026-06-18T14:30:00Z")
//                        .commentTotalCount(34)
//                        .reactionTotalCount(215)
//                        .engagement(249)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_012")
//                        .message("Какую самую глупую ошибку в коде вы искали часами?")
//                        .createdTime("2026-06-18T15:00:00Z")
//                        .commentTotalCount(210)
//                        .reactionTotalCount(480)
//                        .engagement(690)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_013")
//                        .message("Посоветуйте хорошие курсы или книги по Kubernetes.")
//                        .createdTime("2026-06-18T15:40:00Z")
//                        .commentTotalCount(45)
//                        .reactionTotalCount(130)
//                        .engagement(175)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_014")
//                        .message("Топ-5 плагинов для проверки качества кода.")
//                        .createdTime("2026-06-18T16:15:00Z")
//                        .commentTotalCount(3)
//                        .reactionTotalCount(58)
//                        .engagement(61)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_015")
//                        .message("Как работает Garbage Collector в Java под капотом.")
//                        .createdTime("2026-06-18T17:00:00Z")
//                        .commentTotalCount(28)
//                        .reactionTotalCount(190)
//                        .engagement(218)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_016")
//                        .message("Изучаем Docker: базовые команды для выживания.")
//                        .createdTime("2026-06-18T17:45:00Z")
//                        .commentTotalCount(11)
//                        .reactionTotalCount(87)
//                        .engagement(98)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_017")
//                        .message("Почему важно писать Unit-тесты, даже если мало времени.")
//                        .createdTime("2026-06-18T18:30:00Z")
//                        .commentTotalCount(53)
//                        .reactionTotalCount(290)
//                        .engagement(343)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_018")
//                        .message("Запись нашего вчерашнего вебинара по микросервисам.")
//                        .createdTime("2026-06-18T19:20:00Z")
//                        .commentTotalCount(19)
//                        .reactionTotalCount(72)
//                        .engagement(91)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_019")
//                        .message("Краткий обзор трендов веб-разработки на этот год.")
//                        .createdTime("2026-06-18T20:00:00Z")
//                        .commentTotalCount(22)
//                        .reactionTotalCount(115)
//                        .engagement(137)
//                        .build(),
//
//                PostInfoResponse.builder()
//                        .id("post_020")
//                        .message("Мысли на ночь: стоит ли гнаться за красивым кодом в стартапе?")
//                        .createdTime("2026-06-18T21:30:00Z")
//                        .commentTotalCount(67)
//                        .reactionTotalCount(410)
//                        .engagement(477)
//                        .build()
//        );
//
//        return mockPosts;
    }

    @Override
    public List<PostInfoResponse> getEngagementPosts() {

        // todo добавить поле где показывается engagement для каждого поста
        return getLimitedPosts().stream()
                .sorted(Comparator.comparingInt(this::calculateEngagement)
                                .reversed())
                .limit(3)
                .toList();
    }


    private int calculateEngagement(PostInfoResponse post) {
        return post.commentTotalCount() + post.reactionTotalCount();
    }
}
