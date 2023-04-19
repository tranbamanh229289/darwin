package com.manhtb.bookservice.model.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private String id;
    private String name;
    private String author;
    private Boolean isReady;
}
