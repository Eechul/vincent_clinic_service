package com.vincent.clinic.domain.clinic.dto;

import com.vincent.clinic.global.model.SearchQ;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Getter @Setter
@ToString
public class ClinicServiceRequest {

    private SearchQ search;
    private PageRequest pageRequest;

    @Builder
    private ClinicServiceRequest(SearchQ search, PageRequest pageRequest) {
        this.search = search;
        this.pageRequest = pageRequest;
    }

    public static ClinicServiceRequest of(SearchQ search, PageRequest pageRequest) {
        return ClinicServiceRequest.builder()
                .search(search)
                .pageRequest(pageRequest)
                .build();
    }
}
