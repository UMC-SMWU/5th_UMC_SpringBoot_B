package umc.study.service.TempService;

import lombok.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class TempCommandQueryImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {

    }

}
