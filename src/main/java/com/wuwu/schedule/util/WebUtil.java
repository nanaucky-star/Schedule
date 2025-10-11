package com.wuwu.schedule.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wuwu.schedule.common.Result;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

public class WebUtil {
    private static ObjectMapper objectMapper=new ObjectMapper();
    public static  void  writeJson(HttpServletResponse resp, Result result){
        resp.setContentType("application/json;charset=utf-8");


        String s = null;
        try {
            s = objectMapper.writeValueAsString(result);
            resp.getWriter().write(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
