package com.vincent.clinic.global.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class SearchQ {

    private String col;
    private String q;

    @Builder
    private SearchQ(String col, String q) {
        this.col = col;
        this.q = q;
    }

    public static SearchQ create(String col, String q) {
        return SearchQ.builder()
                .col(col)
                .q(q)
                .build();
    }
}
