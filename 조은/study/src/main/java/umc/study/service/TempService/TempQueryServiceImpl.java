package umc.study.service.TempService;

import lombok.*;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.*;
import umc.study.apiPayload.exception.handler.*;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }

}
