package com.example.demo.dto;


import lombok.Data;
import lombok.NonNull;

@Data
@NonNull
public class PurchaseResponse {
    private final String orderTrackingNumber;
}
