package com.example.echo.client;

import com.example.echo.model.Email;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(url = "http://enderecoaqui/externo/", name = "usuario")
public interface ExternoClient {

    @PostMapping("/enviar-email")
     boolean enviarEmail(@RequestBody Email email);

}
