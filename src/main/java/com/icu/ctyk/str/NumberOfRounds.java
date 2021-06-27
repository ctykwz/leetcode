package com.icu.ctyk.str;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.MINUTES;


/**
 * @author ctykwz on 2021-06-26 21:25
 */
public class NumberOfRounds {

    public static void main(String[] args) {
        System.out.println(new NumberOfRounds().numberOfRounds("20:00", "06:00"));
    }

    public int numberOfRounds(String startTime, String finishTime) {
        LocalTime start = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime end = LocalTime.parse(finishTime, DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime time = start.getMinute() % 15 == 0 ? start : start.plusMinutes(15 - start.getMinute() % 15);
        int min;
        if (end.isBefore(start)) {
            LocalTime tmp = LocalTime.parse("00:00", DateTimeFormatter.ofPattern("HH:mm"));
            long val = MINUTES.between(time, tmp);
            min = (int) ((val < 0 ? 1440 + val : val) + MINUTES.between(tmp, end));
        } else {
            min = (int) MINUTES.between(time, end);
        }
        return min < 0 ? 0 : min / 15;
    }
}
