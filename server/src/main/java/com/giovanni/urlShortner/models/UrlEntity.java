package com.giovanni.urlShortner.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class UrlEntity {
    private String originalUrl;
    private Long clickCount;
}
