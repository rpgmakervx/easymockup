package org.easyarch.easymockup.handler;

import org.easyarch.easymockup.util.TypeEnum;
import org.easyarch.easymockup.util.ValueGen;
import org.easyarch.netpet.web.http.request.HandlerRequest;
import org.easyarch.netpet.web.http.response.HandlerResponse;
import org.easyarch.netpet.web.mvc.action.handler.HttpHandler;
import org.easyarch.netpet.web.mvc.entity.Json;
import org.easyarch.netpet.web.server.App;

import java.util.List;
import java.util.Map;

/**
 * Created by xingtianyu on 17-5-7
 * 下午3:02
 * description:
 */

public class StringApiHandler implements HttpHandler {

    private App app;

    private ValueGen gen;

    public StringApiHandler(App app){
        this.app = app;
        gen = new ValueGen();
    }

    @Override
    public void handle(HandlerRequest request, final HandlerResponse response) throws Exception {
        Json jsonData = request.getJson();
        String method = (String) jsonData.get("method");
        String interfas = (String) jsonData.get("interface");
        final List<Map<String,String>> inputs = (List<Map<String, String>>) jsonData.get("input");
        final List<Map<String,String>> outputs = (List<Map<String, String>>) jsonData.get("output");
        System.out.println("StringApiData:"+jsonData);
        HttpHandler handler =  new HttpHandler() {
            @Override
            public void handle(HandlerRequest request, HandlerResponse response) throws Exception {
                StringBuffer respData = new StringBuffer();
                for (Map<String,String> params : inputs){
                    String pName = params.get("paramname");
                    String data = request.getParam(pName);
                    if (data == null){
                        response.text("code=400&message=调用参数异常");
                        return;
                    }
                }
                for (Map<String,String> params : outputs){
                    String pName = params.get("paramname");
                    String pType = params.get("paramtype");
                    respData.append(pName+"="+gen.getValue(Class.forName(TypeEnum.getName(pType)))+"&");
                }
                response.text(respData.toString());
            }
        };
        switch (method){
            case "GET":app.get(interfas, handler);break;
            case "POST":app.post(interfas,handler);break;
            case "PUT":app.put(interfas,handler);break;
            case "DELETE":app.delete(interfas,handler);break;
        }
        response.json(new Json("code",200,"message","ok"));
    }
}
