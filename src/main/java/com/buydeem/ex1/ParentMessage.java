package com.buydeem.ex1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @Auther: zengchao
 * @Date: 2019/7/26 20:33
 * @Description:
 */
@Data
@ToString
@AllArgsConstructor
public class ParentMessage {
    private String id;
    private String content;
}
