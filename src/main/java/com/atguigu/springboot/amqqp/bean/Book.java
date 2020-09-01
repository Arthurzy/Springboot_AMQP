package com.atguigu.springboot.amqqp.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter, toString 
@AllArgsConstructor // 全参构造
@NoArgsConstructor  // 无参构造
public class Book {

    private String bookName;   
    private String author;
}
