package org.easyarch.easymockup.handler;

import org.easyarch.netpet.web.http.request.HandlerRequest;
import org.easyarch.netpet.web.http.response.HandlerResponse;
import org.easyarch.netpet.web.mvc.action.handler.HttpHandler;

/**
 * Created by xingtianyu on 17-5-7
 * 下午1:33
 * description:
 */

public class IndexPageHandler implements HttpHandler {


    @Override
    public void handle(HandlerRequest request, HandlerResponse response) throws Exception {
        response.html("index");
    }
}
