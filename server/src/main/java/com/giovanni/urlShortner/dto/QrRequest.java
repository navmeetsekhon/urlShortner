package com.giovanni.urlShortner.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QrRequest {
    private String url;

    public String toString(){
    return "Url: "+this.getUrl();
}
}
