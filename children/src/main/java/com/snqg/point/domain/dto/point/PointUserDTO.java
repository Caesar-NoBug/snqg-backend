package com.snqg.point.domain.dto.point;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PointUserDTO {
    /**
     * 查询结果包含的字段有积分记录字段之中的user_id/changed_point/changed_time
     * 以及用户记录字段之中的address，假如is_delete=1，则将其舍弃
     */
    private String userId;
    private String address;
    private int changedPoint;
    private LocalDateTime changeTime;
}
