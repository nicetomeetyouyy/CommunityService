package com.fy.hander;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebFilter(urlPatterns = "/*",filterName = "AuthorityFilter")
public class AuthorityFilter implements Filter {
//  不拦截的url
    private static final String[] excludePathPatterns = { "login/register"};
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse res = (HttpServletResponse)servletResponse;
        String url=req.getRequestURI();
        filterChain.doFilter(req, res);
      /*  if (Arrays.asList(excludePathPatterns).contains(url)) {
            //放行，相当于第一种方法中LoginInterceptor返回值为true
            filterChain.doFilter(req, res);
        }*/

    }

    @Override
    public void destroy() {

    }
}
