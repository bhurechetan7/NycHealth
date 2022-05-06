package com.nyc.health.Clinic.Interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

public class BasicAuthenticationInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      //  return super.preHandle(request, response, handler);
        String authHeader = request.getHeader("Authorization");
          if(authHeader !=null){
              String userNameandPassHash = authHeader.split(" ")[1];
              //System.out.println("Authorized");
              System.out.println(userNameandPassHash);
              String userNameandPass = new String(Base64.getDecoder().decode(userNameandPassHash));
              System.out.println(userNameandPass);
              String userName = userNameandPass.split(":")[0];
              String userPass = userNameandPass.split(":")[1];
              if(userName.equalsIgnoreCase("chets") && userPass.equals("chets123")){

                   return true;
              }
              else
              {
                  response.sendError(401, "Unauthorized");
                  return false;
              }
          } else{
              response.sendError(401, "Unauthorized");
              return false;
               }
}}
