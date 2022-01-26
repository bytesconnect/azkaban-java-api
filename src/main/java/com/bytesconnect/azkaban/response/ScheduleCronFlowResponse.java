package com.bytesconnect.azkaban.response;

/**
 * 定时调度Flow响应
 */
public class ScheduleCronFlowResponse extends BaseResponse {
    private String scheduleId;

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }
}
