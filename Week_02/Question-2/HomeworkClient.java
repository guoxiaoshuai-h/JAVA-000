package cn.tongdun.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-10-28 17:27
 */
public class HomeworkClient {

    private static final String URL = "http://localhost:8801";

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet httpGet = new HttpGet(URL);

        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpGet);
            System.out.println("响应状态： " + response.getStatusLine());
            //从响应模型中获取响应实体
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                System.out.println("响应内容长度为: " + entity.getContentLength());
                System.out.println("响应内容为: " + EntityUtils.toString(entity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null){
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
