package com.snqg.point.domain.dto.point.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RankingRequest {
  
    @ApiModelProperty(value = "请求：在积分排名界面之中显示积分排名的数值；" +
            "参数功能：设定排名的时间范围:" +
            "1)传入\"total\", 限定时间范围为全部（对应总积分）" +
            "2)传入\"year\", 限定时间范围为年（对应年度积分）" +
            "3)传入\"mouth\", 限定时间范围为月（对应月度积分）" +
            "4)传入\"week\", 限定时间范围为周（对应近七日在组内排名，传入这个参数时rankingRange请设置为\"group\"）",
            example = "total")
    private String timeRange;
  
    @ApiModelProperty(value = "请求：在积分排名界面之中显示积分排名的数值；" +
            "参数功能：设定排名的组别范围:" +
            "1)传入\"system\", 表示在系统范围内进行排名（会在整个数据库之中进行检索排名）" +
            "2)传入\"group\",  表示在组内进行排名（会在具有相同地理位置的孩子中间进行排名）",
            example = "system")
    private String rankingRange;
}
