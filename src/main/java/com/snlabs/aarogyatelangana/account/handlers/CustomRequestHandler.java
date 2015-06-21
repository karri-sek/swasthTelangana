package com.snlabs.aarogyatelangana.account.handlers;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomRequestHandler extends HandlerInterceptorAdapter {
    //preHandle() : Before a request is handled by a request handler.
    public boolean preHandleH(HttpServletResponse response, HttpServletRequest request, Object handler) {
        return true;
    }

    /*
    postHandle() : After a request is handled by a request handler. It gives access to the returned ModelAndView object,
     so you can manipulate the model attributes in it.
     */
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) {


    }

    /*afterCompletion() : After the completion of all request processing i.e.
      after the view has been rendered.
    */
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                ModelAndView modelAndView
    ) {

    }

}
