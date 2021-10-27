package com.project.ciclo3.reto3.custom;

import com.project.ciclo3.reto3.modelo.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CountClients {
    private Long total;
    private Client client;

}
