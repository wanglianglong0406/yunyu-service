package com.mp.bo;

import lombok.Data;

@Data
public class OrderBO {

    private long price;
    private int orderStatus;
    private long orderId;
    private long userI;
    private int num;
    private String produceName;
}
