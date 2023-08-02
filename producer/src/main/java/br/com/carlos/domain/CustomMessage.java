package br.com.carlos.domain;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CustomMessage {

    private String messageId;
    private String message;
    private Date messageDate;

}