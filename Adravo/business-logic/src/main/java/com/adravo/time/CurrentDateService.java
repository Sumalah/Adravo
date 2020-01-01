package com.adravo.time;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CurrentDateService {

    public LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
}
