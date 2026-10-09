package com.duc.cinebook.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("RedisToken")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class RedisToken {
    @Id
    String jwtId;

    @TimeToLive(unit = TimeUnit.SECONDS)
    long timeToLive;
}
