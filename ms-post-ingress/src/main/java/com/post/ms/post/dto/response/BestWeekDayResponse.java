package com.post.ms.post.dto.response;

import lombok.Builder;

import java.time.DayOfWeek;

@Builder
public record BestWeekDayResponse(
        DayOfWeek day,
        Integer likes
) {
}
