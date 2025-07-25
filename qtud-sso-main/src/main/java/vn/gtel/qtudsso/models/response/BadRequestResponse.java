package vn.gtel.qtudsso.models.response;


import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import vn.gtel.qtudsso.utils.ApplicationException;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class BadRequestResponse {
    private String title;
    private String errorCode;
    private String message;
    private Map<String, Object> data;
    private String uri;
    private LocalDateTime time;
    private String requestId;


    public BadRequestResponse (ApplicationException ex , HttpServletRequest httpServletRequest){
        this.title = ex.getTitle();
        this.errorCode = ex.getCode();
        this.message = ex.getMessage();
        this.data = ex.getData();
        this.uri = httpServletRequest.getRequestURI();
        this.time = LocalDateTime.now();
    }
}
