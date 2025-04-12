package com.itheima.tliasweb.pojo;

import lombok.Data;

import java.util.List;
@Data

public class PageResult<T> {
    private Long total;
    private List<T> rows;
}
