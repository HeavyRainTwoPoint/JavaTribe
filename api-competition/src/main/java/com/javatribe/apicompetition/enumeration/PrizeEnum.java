package com.javatribe.apicompetition.enumeration;

public enum PrizeEnum {

    FIRST(1,"一等奖"),
    SECOND(2,"二等奖"),
    THIRD(3,"三等奖"),
    OTHER(4,"优秀奖");

    private int order;

    private String orderText;

    PrizeEnum(int order,String orderText){
        this.order = order;
        this.orderText = orderText;
    }

    public static int getOrder(String orderText){
        for (PrizeEnum prizeEnum : PrizeEnum.values()){
            if (prizeEnum.orderText.equals(orderText)){
                return prizeEnum.order;
            }
        }
        return -1;
    }
}
