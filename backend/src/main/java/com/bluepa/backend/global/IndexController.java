package com.bluepa.backend.global;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class IndexController {

    @GetMapping
    public void index(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("/api/oauth2/sign-in");
    }
}
