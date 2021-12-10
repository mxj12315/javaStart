/*
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class PostTest {
    public static void main(String[] args) {
        sendPost();
    }

    public static void sendPost(){
        String value="12222";

        //创建post请求对象
        HttpPost post = new HttpPost("http://localhost:8080/test");
        try {
            //创建参数集合
            List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
            //添加参数
            list.add(new BasicNameValuePair("key", value));
            list.add(new BasicNameValuePair("releaseDate","2020-07-14 09:55:20"));
            //把参数放入请求对象，，post发送的参数list，指定格式
            post.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
            //添加请求头参数
            post.addHeader("timestamp","1594695607545");
            CloseableHttpClient client = HttpClients.createDefault();
            //启动执行请求，并获得返回值
            CloseableHttpResponse response = client.execute(post);
            //得到返回的entity对象
            HttpEntity entity = response.getEntity();
            //把实体对象转换为string
            String result = EntityUtils.toString(entity, "UTF-8");
            //返回内容
            System.out.println(result);
        } catch (Exception e1) {
            e1.printStackTrace();

        }
    }
}
*/
