package com.ex.gateway.gateway;

import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.ZuulFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

//  @Override
  public boolean shouldFilter() {
    return true;
  }

//  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
    
    log.info(" ***************  Request to port 8686, will get routed to zuul url (zuul.routes.books-app.url=http://localhost:8090) in application.properties file *************** ");
    log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

    return null;
  }

}

//Execute gateway application and hit the below URLs... 
//http://localhost:8686/books-app/checked-out
//http://localhost:8686/books-app/available
//...request get routed to *book* application methods through port 8090, which was defined in zuul(books-app)...
//(zuul.routes.books-app.url=http://localhost:8090 in gateway application)
