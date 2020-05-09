package com.example.microservices.netflixzuulapigatewayserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.jersey.api.core.HttpContext;
import com.sun.jersey.api.core.HttpRequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class ZuulLoggingFilter extends ZuulFilter {
    /**
     * here we deicide filter type, i.e if it should filter before the request or after the request or only when
     * if there is error
     * */

    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * In this method we assign order to the filter
     * */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * In this method we decide on logic if request should be filterd
     * */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * he we implement the actual logic for filter for each request
     */
    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        log.info("request -> {} request-uri -> {}", request, request.getRequestURI());
        return null;
    }
}
