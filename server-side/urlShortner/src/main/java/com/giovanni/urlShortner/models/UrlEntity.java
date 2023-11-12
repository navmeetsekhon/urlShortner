package com.giovanni.urlShortner.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="url_table")
public class UrlEntity {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="orginalUrl",unique = true,nullable = false)
    private String originalUrl;

    @Column(name="urlKey",unique = true,nullable = false,columnDefinition = "TEXT")
    private String urlKey;

    @Column(name="clickCount",nullable = false)
    private Long clickCount;


}
