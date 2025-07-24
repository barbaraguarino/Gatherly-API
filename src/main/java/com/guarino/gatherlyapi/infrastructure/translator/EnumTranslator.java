package com.guarino.gatherlyapi.infrastructure.translator;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class EnumTranslator {

    private final MessageSource messageSource;

    public EnumTranslator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String translate(Enum<?> anEnum) {
        if (anEnum == null) {
            return null;
        }
        String key = "enum."
                + anEnum.getClass().getSimpleName().toLowerCase()
                + "."
                + anEnum.name().toLowerCase();
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }
}
