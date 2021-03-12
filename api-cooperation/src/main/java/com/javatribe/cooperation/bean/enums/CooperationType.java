package com.javatribe.cooperation.bean.enums;

import lombok.AllArgsConstructor;

/**
 * @author LCW
 * @since 2021/2/28 10:27
 **/
@AllArgsConstructor
public enum CooperationType {

    InCooperation(0,"对内交流"),
    OutCooperation(1, "对外交流");

    public int getType() {
        return type;
    }

    int type;
    String msg;
}
