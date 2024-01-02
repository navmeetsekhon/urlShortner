package com.giovanni.urlShortner.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class QrResponse {
    private String path;
}
