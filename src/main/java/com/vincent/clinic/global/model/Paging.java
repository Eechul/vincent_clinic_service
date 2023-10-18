package com.vincent.clinic.global.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter
@ToString
public class Paging<T> {

    private List<T> datas;
    private int totalPage;
    private long totalCount;
    private int currentPage;

    @Builder
    public Paging(List<T> datas, int totalPage, long totalCount, int currentPage) {
        this.datas = datas;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.totalCount = totalCount;
    }
}
