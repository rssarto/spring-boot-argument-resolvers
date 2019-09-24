package com.resolvers.resolvers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.RequestParamMapMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Slf4j
public class CustomArgumentResolver extends RequestParamMapMethodArgumentResolver {

    public CustomArgumentResolver(){
        CustomArgumentResolver.log.info("=============================== CustomArgumentResolver is ready ===============================");
    }

    @Override
    public boolean supportsParameter(final MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(MultiValueMap.class);
    }

    @Override
    public Object resolveArgument(final MethodParameter methodParameter, final ModelAndViewContainer modelAndViewContainer, final NativeWebRequest nativeWebRequest, final WebDataBinderFactory webDataBinderFactory) throws Exception {
        final Object resolvedObject = super.resolveArgument(methodParameter, modelAndViewContainer, nativeWebRequest, webDataBinderFactory);
        final MultiValueMap<String, String> params = (MultiValueMap) resolvedObject;
        params.entrySet().stream().forEach(stringListEntry -> {
            for(int index = 0; index < stringListEntry.getValue().size(); index++){
                stringListEntry.getValue().set(index, stringListEntry.getValue().get(index) + "_suffix" );
            }
        });
        return resolvedObject;
    }
}
