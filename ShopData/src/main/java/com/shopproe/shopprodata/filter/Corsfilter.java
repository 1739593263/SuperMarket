package com.shopproe.shopprodata.filter;


import javax.servlet.*;
import java.io.IOException;

public class Corsfilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        HttpServletRequestrequest = (HttpServletRequest) req;
//        HttpServletResponseresponse = (HttpServletResponse) res;
//        response.setHeader("Access-Control-Allow-Origin",request.getHeader("origin"));
////response.setHeader("Access-Control-Allow-Origin","*");
//        response.setHeader("Access-Control-Allow-Methods", "POST,GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age","3600");
//        response.setHeader("Access-Control-Allow-Headers","x-requested-with,Cache-Control,Pragma,Content-Type,Token");
//        response.setHeader("Access-Control-Allow-Credentials","true");
//        chain.doFilter(req,res);
    }
}
