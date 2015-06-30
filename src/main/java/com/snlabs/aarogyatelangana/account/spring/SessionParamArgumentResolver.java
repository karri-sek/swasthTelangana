package com.snlabs.aarogyatelangana.account.spring;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.MethodParameter;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.snlabs.aarogyatelangana.account.exceptions.LoginRequiredException;

public class SessionParamArgumentResolver implements
        HandlerMethodArgumentResolver {
    public Object resolveArgument(MethodParameter param,
                                  NativeWebRequest request) throws Exception {
        Annotation[] paramAnns = param.getParameterAnnotations();
        Class<?> paramType = param.getParameterType();
        for (Annotation paramAnn : paramAnns) {
            // check if annotation is SessionParam
            if (SessionParam.class.isInstance(paramAnn)) {
                // get http session using the request object.
                HttpServletRequest httprequest = (HttpServletRequest) request
                        .getNativeRequest();
                HttpSession session = httprequest.getSession(false);

                // get values passed to the annotation
                SessionParam sessionparam = (SessionParam) paramAnn;
                String paramName = sessionparam.value();
                boolean required = sessionparam.required();
                String defaultvalue = sessionparam.defaultValue();

                // get attribute from session.
                Object result = null;

                if (session != null) {
                    result = session.getAttribute(paramName);
                }
                if (result == null) {
                    if ("userDetails".equals(paramName)) {
                        raiseLoginRequiredExeption(paramName, paramType);
                    }
                    raiseSessionRequiredException(paramName, paramType, "");
                }
                if (result == null && required && session == null)
                    raiseSessionRequiredException(paramName, paramType,
                            "Session null : ");
                if (result == null && required)
                    raiseMissingParameterException(paramName, paramType);

                return result;
            }
        }

        return null;
    }

    protected void raiseMissingParameterException(String paramName,
                                                  Class paramType) throws Exception {
        throw new IllegalStateException("Missing parameter '" + paramName
                + "' of type [" + paramType.getName() + "]");
    }

    protected void raiseSessionRequiredException(String paramName,
                                                 Class paramType, String notes) throws Exception {
        throw new HttpSessionRequiredException(notes
                + " No HttpSession found for resolving parameter '" + paramName
                + "' of type [" + paramType.getName() + "]");
    }

    protected void raiseLoginRequiredExeption(String paramName, Class paramType)
            throws Exception {
        throw new LoginRequiredException("-1","Login required !!!");
    }

    public static void setAurgument(HttpSession session, Object obj) {
        setAurgument(session, obj, obj.getClass().getName());
    }

    public static void setAurgument(HttpSession session, Object obj,
                                    String paramName) {
        session.setAttribute(paramName, obj);
    }

    public static void removeAurgument(HttpSession session, Object obj) {
        removeAurgument(session, obj, obj.getClass().getName());
    }

    public static void removeAurgument(HttpSession session, Object obj,
                                       String paramName) {
        session.removeAttribute(paramName);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // TODO Auto-generated method stub
        return parameter.hasParameterAnnotation(SessionParam.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        return resolveArgument(parameter, webRequest);
    }

}