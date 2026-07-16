package com.enterProject.enterProject.auth.presentation.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpRequestDTO {
    // TODO : i18n Message ?ъ슜?섎룄濡?援ы쁽
    @NotBlank(message = "?대찓?쇱쓣 ?낅젰?댁＜?몄슂.")
    @Email(message = "?щ컮瑜??대찓???뺤떇???꾨떃?덈떎.")
    private String email;

    @NotBlank(message = "鍮꾨?踰덊샇瑜??낅젰?댁＜?몄슂.")
    private String password;

    @NotBlank(message = "?대쫫???낅젰?댁＜?몄슂.")
    private String name;
}
