package com.zdw.snail.model;

import lombok.Data;

import java.util.List;

/**
 * 用于包装list数据的类
 */
@Data
public class PageResult {
    private List<?> data;

    private Integer totalCount;
}
