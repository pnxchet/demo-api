package com.demo.demoapi.util;

import com.demo.demoapi.application.exception.BadRequestException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConvertUtil {
    public static LocalDateTime convertStringToLocalDateTime(String date) {
        if (date == null) {
            return null;
        }
        try {
            return LocalDateTime.parse(date);
        } catch (Exception e) {
            throw new BadRequestException("Invalid date format");
        }
    }
}
