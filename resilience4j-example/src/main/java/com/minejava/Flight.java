package com.minejava;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    String to;
    String from;
    String flightData;
    String flightNum;


}
