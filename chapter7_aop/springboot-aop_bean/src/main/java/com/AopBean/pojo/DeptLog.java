package com.AopBean.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author hxz
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptLog {
    private LocalDateTime createTime; //创建时间
    private String log;
}
