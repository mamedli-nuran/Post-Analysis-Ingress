package com.post.ms.post.util;

import com.post.ms.post.dto.response.PostInfoResponse;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public enum MockPostsGenerator {
    POSTS_GENERATOR;

    final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

    // this is mock posts, that use if meta api is not available
    public List<PostInfoResponse> getMockPosts(){

        List<PostInfoResponse> mockPosts = List.of(
                PostInfoResponse.builder()
                        .id("post_001")
                        .message("Разбор архитектурных паттернов в Java.")
                        .createdTime(OffsetDateTime.parse("2026-06-18T07:48:20+0000", formatter))
                        .commentTotalCount(15)
                        .reactionTotalCount(120)
                        .build(),

                PostInfoResponse.builder()
                        .id("post_002")
                        .message("Почему не стоит бояться переходить на новые версии JDK.")
                        .createdTime(OffsetDateTime.parse("2026-06-18T07:48:20+0000", formatter))
                        .commentTotalCount(42)
                        .reactionTotalCount(310)
                        .build(),

                PostInfoResponse.builder()
                        .id("post_003")
                        .message("Шпаргалка по работе с Stream API.")
                        .createdTime(OffsetDateTime.parse("2026-06-18T07:48:20+0000", formatter))
                        .commentTotalCount(8)
                        .reactionTotalCount(95)
                        .build(),

                PostInfoResponse.builder()
                        .id("post_004")
                        .message("Как настроить CI/CD пайплайн за 10 минут.")
                        .createdTime(OffsetDateTime.parse("2026-06-18T07:48:20+0000", formatter))
                        .commentTotalCount(23)
                        .reactionTotalCount(140)
                        .build(),

                PostInfoResponse.builder()
                        .id("post_005")
                        .message("Вышел новый релиз Spring Boot! Обсуждаем фичи.")
                        .createdTime(OffsetDateTime.parse("2026-06-18T07:48:20+0000", formatter))
                        .commentTotalCount(31)
                        .reactionTotalCount(185)
                        .build(),

                PostInfoResponse.builder()
                        .id("post_006")
                        .message("Утренняя кофе-пауза. Какую IDE вы предпочитаете?")
                        .createdTime(OffsetDateTime.parse("2026-06-18T07:48:20+0000", formatter))
                        .commentTotalCount(54)
                        .reactionTotalCount(92)
                        .build(),

                PostInfoResponse.builder()
                        .id("post_007")
                        .message("Напоминание: сегодня тех. работы на сервере в 23:00.")
                        .createdTime(OffsetDateTime.parse("2026-06-18T07:48:20+0000", formatter))
                        .commentTotalCount(4)
                        .reactionTotalCount(18)
                        .build(),

                PostInfoResponse.builder()
                        .id("post_008")
                        .message("Наша команда ищет Senior Java Developer. Пишите в ЛС.")
                        .createdTime(OffsetDateTime.parse("2026-06-18T07:48:20+0000", formatter))
                        .commentTotalCount(12)
                        .reactionTotalCount(64)
                        .build(),

                PostInfoResponse.builder()
                        .id("post_009")
                        .message("10 скрытых фич IntelliJ IDEA, о которых вы не знали.")
                        .createdTime(OffsetDateTime.parse("2026-06-18T07:48:20+0000", formatter))
                        .commentTotalCount(89)
                        .reactionTotalCount(620)
                        .build(),

                PostInfoResponse.builder()
                        .id("post_010")
                        .message("Мемы про деплой в пятницу вечером. Листайте карусель.")
                        .createdTime(OffsetDateTime.parse("2026-06-18T07:48:20+0000", formatter))
                        .commentTotalCount(156)
                        .reactionTotalCount(1240)
                        .build()

        );

        return mockPosts;
    }
}
