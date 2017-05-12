package org.easyarch.easymockup;

import org.easyarch.easymockup.handler.*;
import org.easyarch.netpet.web.http.request.HandlerRequest;
import org.easyarch.netpet.web.http.response.HandlerResponse;
import org.easyarch.netpet.web.mvc.action.handler.HttpHandler;
import org.easyarch.netpet.web.server.App;

/**
 * Created by xingtianyu on 17-5-7
 * 下午1:23
 * description:
 */

public class Application {

    public static void main(String[] args) {
        App app = new App();
        app.config().notFound("404");
        app.get("/index",new IndexPageHandler())
                .get("/test",new TestPageHandler())
                .get("/gallery", new HttpHandler() {
                    @Override
                    public void handle(HandlerRequest request, HandlerResponse response) throws Exception {
                        response.html("gallery");
                    }
                })
                .get("/contact", new HttpHandler() {
                    @Override
                    public void handle(HandlerRequest request, HandlerResponse response) throws Exception {
                        response.html("contact");
                    }
                })
                .post("/api/string",new StringApiHandler(app))
                .post("/api/json",new JsonApiHandler(app))
                .post("/api/html",new PageApiHandler(app))
                .post("/upload/page",new UpLoadHtmlHandler())
                .post("/code/run",new DynamicCodeHandler())
        .start(3000);
    }
}
