package org.easyarch.easymockup.handler;

import org.easyarch.netpet.web.http.request.HandlerRequest;
import org.easyarch.netpet.web.http.response.HandlerResponse;
import org.easyarch.netpet.web.mvc.action.handler.HttpHandler;

/**
 * Created by xingtianyu on 17-5-7
 * 下午2:09
 * description:
 */

public class TestPageHandler implements HttpHandler {


    @Override
    public void handle(HandlerRequest request, HandlerResponse response) throws Exception {
        response.html("operate");
    }
}
