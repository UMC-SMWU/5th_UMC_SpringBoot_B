package umc.study.apiPayload.code;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.internal.lang.annotation.ajcDeclareEoW;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Getter
@Builder
public class ErrorReasonDTO {
    private HttpStatus httpStatus;
    private final String code;
    private final String message;
    private final boolean isSuccess;
    public boolean getIsSuccess(){return isSuccess;}
}
