package com.vincent.clinic.global.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.AbstractView;
import org.springframework.web.util.JavaScriptUtils;

import java.io.OutputStream;
import java.util.Map;

public class AlertView extends AbstractView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        boolean iframe = (boolean) (model.get("iframe") == null ? false : model.get("iframe"));
        String value = "<html>";
        value += "<head><meta charset='utf-8'/></head>";
        value += "<script type='text/javascript'>";
        value += "alert('" +  JavaScriptUtils.javaScriptEscape((String) model.get("message")) + "');";

        if(!iframe){
            if(model.get("redirect") != null){
                value += "location.href='" + model.get("redirect") +"';";
            }else if(model.get("replace") != null) {
                value += "if( history.length <= 1){";
                value += "window.close();";
                value += "}else {";
                value += "window.location.replace('"+model.get("replace")+"');";
                value += "}";
            }else{
                value += "if( history.length <= 1){";
                value += "window.close();";
                value += "}else {";
                value += "history.back();";
                value += "}";
            }
        }
        value += "</script>";
        value += "</html>";
        OutputStream out = response.getOutputStream();
        out.write(value.getBytes());
        out.flush();
    }
}
