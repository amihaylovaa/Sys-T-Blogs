package aggm.personal.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Service;

@Service
public class ApplicationConversionService {

    @Autowired
    private GenericConversionService genericConversionService;


    public <SOURCE, TARGET> TARGET convert(SOURCE source, Class<TARGET> target) {
        return genericConversionService.convert(source, target);
    }
}
