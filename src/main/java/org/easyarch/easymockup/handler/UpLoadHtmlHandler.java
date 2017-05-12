package org.easyarch.easymockup.handler;

import org.easyarch.netpet.kits.file.FileKits;
import org.easyarch.netpet.web.context.HandlerContext;
import org.easyarch.netpet.web.http.request.HandlerRequest;
import org.easyarch.netpet.web.http.response.HandlerResponse;
import org.easyarch.netpet.web.mvc.action.handler.HttpHandler;
import org.easyarch.netpet.web.mvc.entity.Json;
import org.easyarch.netpet.web.mvc.entity.UploadFile;

/**
 * Created by xingtianyu on 17-5-12
 * 下午6:05
 * description:
 */

public class UpLoadHtmlHandler implements HttpHandler{

    @Override
    public void handle(HandlerRequest request, HandlerResponse response) throws Exception {
        HandlerContext context = request.getContext();
        UploadFile file = request.file("html");
        String path = context.getWebView()+context.getViewPrefix()+file.getFileName();
        System.out.println("upload path:"+path);
        FileKits.write(path,file.getContent());
        response.json(new Json("code",200,"message","success"));
    }
}
