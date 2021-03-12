package com.javatribe.cooperation.bean.enums;

import lombok.AllArgsConstructor;

/**
 * @author LCW
 * @since 2021/2/28 10:27
 **/
@AllArgsConstructor
public enum NewsType {

    HeightPriority(1,"高优先级"),
    LowPriority(0, "低优先级");

    public int getType() {
        return type;
    }

    int type;
    String msg;
}
