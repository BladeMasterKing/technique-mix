package org.ding.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author wangjiansheng
 * @version 1.0.0
 */
public class JsoupTest {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://www.taobao.com").get();
        System.out.println(document.body());

    }
}
