package org.easyarch.easymockup;

import org.easyarch.easymockup.handler.*;
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
                .post("/api/string",new StringApiHandler(app))
                .post("/api/json",new JsonApiHandler(app))
                .post("/api/html",new PageApiHandler(app))
                .post("/code/run",new DynamicCodeHandler())
        .start(3000);
    }
}
