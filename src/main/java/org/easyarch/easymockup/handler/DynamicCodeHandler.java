package org.easyarch.easymockup.handler;

import com.itranswarp.compiler.JavaStringCompiler;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.easyarch.netpet.web.http.request.HandlerRequest;
import org.easyarch.netpet.web.http.response.HandlerResponse;
import org.easyarch.netpet.web.mvc.action.handler.HttpHandler;
import org.easyarch.netpet.web.mvc.entity.Json;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by xingtianyu on 17-5-7
 * 下午9:39
 * description:
 */

public class DynamicCodeHandler implements HttpHandler {

    @Override
    public void handle(HandlerRequest request, HandlerResponse response) throws Exception {
        ByteOutputStream baos = new ByteOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream print = System.out;
        System.setOut(ps);

        Json json = request.getJson();
        String sourceCode = (String) json.get("code");

        JavaStringCompiler compiler = new JavaStringCompiler();
        Map<String, byte[]> results = compiler.compile("Main.java", sourceCode);
        Class<?> clazz = compiler.loadClass("Main", results);

        Method method = clazz.getDeclaredMethod("main", String[].class);
        method.invoke(null,(Object)null);
        System.setOut(print);
        response.json(new Json("result",new String(baos.getBytes())));
//        System.out.println("invoke result:"+new String(baos.getBytes()));
    }
}
