package com.javatribe.cooperation.bean.enums;

import lombok.AllArgsConstructor;

/**
 * @author LCW
 * @since 2021/2/28 10:27
 **/
@AllArgsConstructor
public enum CommunicationType {

    In_Communication(0,"对内交流"),
    Out_Communication(1, "对外交流");

    int type;
    String msg;
}
