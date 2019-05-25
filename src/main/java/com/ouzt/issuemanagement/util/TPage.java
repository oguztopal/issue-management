package com.ouzt.issuemanagement.util;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public class TPage<T> {
    private int number ; //kaçıncı sayfa
    private int size ; //bir sayfada kaç
    private Sort sort; //sıralama
    private int totalPages; //toplam sayfa
    private Long totalElement; //toplam kayıt
    private List<T> content;

    public void setStat(Page page, List<T> list){
        this.number = page.getNumber();
        this.size = page.getSize();
        this.sort = page.getSort();
        this.totalPages = page.getTotalPages();
        this.totalElement = page.getTotalElements();
        this.content = list;
    }
}
