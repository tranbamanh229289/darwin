package com.manhtb.bookservice.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookRequest {
    private String id;
    private String name;
    private String author;
    private Boolean isReady;
}
