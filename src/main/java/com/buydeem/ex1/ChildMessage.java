package com.buydeem.ex1;

import lombok.Data;
import lombok.ToString;

/**
 * @Auther: zengchao
 * @Date: 2019/7/26 20:35
 * @Description:
 */
@Data
@ToString
public class ChildMessage extends ParentMessage{
    private String actionName;

    public ChildMessage(String id, String content, String actionName) {
        super(id, content);
        this.actionName = actionName;
    }
}
