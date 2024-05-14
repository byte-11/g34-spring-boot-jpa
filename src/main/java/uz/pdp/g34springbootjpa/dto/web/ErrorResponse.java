package uz.pdp.g34springbootjpa.dto.web;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.g34springbootjpa.error.ErrorCode;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private String errorMessage;
    private String errorCode;
    private String body;
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    public static ErrorResponse generate(final ErrorCode errorCode, final String message) {
        return ErrorResponse.builder()
                .errorMessage(message)
                .errorCode(errorCode.name())
                .build();
    }
}
