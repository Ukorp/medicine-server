package com.database.medicine.dto.mail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MailResponse {
    private Integer id;
    private String userName;
    private String doctorName;
    private String serviceName;
    private Integer price;
    private String branchName;
    private String branchAddress;
    private LocalDateTime date;
    private String email;
}
