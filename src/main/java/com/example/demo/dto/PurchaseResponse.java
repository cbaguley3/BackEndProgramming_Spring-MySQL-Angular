package com.example.demo.dto;


import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Data
@Getter
@Setter
@NonNull
public class PurchaseResponse {
    private final String orderTrackingNumber;
}
