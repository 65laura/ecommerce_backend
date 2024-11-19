package com.onlineshopping.trial.enums;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageUtil  {
    private static final int defaultSize = 20;
    private static final int defaultPageNumber = 0;

    public static Pageable getPageable(Integer pageNumber, Integer pageSize){
        if(pageNumber != null && pageSize != null) {
            if(pageNumber <= 0 || pageSize <= 0) {
                throw new RuntimeException("Page size or page number should be greater that 0");
            }
            pageNumber --;
            return PageRequest.of(pageNumber, pageSize);
        } else if(pageNumber != null){
            pageNumber --;
            return PageRequest.of(pageNumber, defaultSize);
        } else
            return PageRequest.of(defaultPageNumber, pageSize);
    }
}
