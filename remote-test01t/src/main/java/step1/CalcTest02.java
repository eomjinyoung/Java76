package step1;

import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class CalcTest02 {

  public static void main(String[] args) throws Exception {
    HttpGet httget = new HttpGet(
        "http://192.168.0.29:8080/remote01t/calc");
    httget.addHeader("x-calc-method", "minus");
    httget.addHeader("x-calc-a", "10");
    httget.addHeader("x-calc-b", "30");
    
    CloseableHttpClient httpclient = HttpClients.createDefault();
    CloseableHttpResponse response = httpclient.execute(httget);
    
    try {
      HttpEntity entity = response.getEntity();
      
      Gson gson = new Gson();
      HashMap<?,?> map = gson.fromJson(
          EntityUtils.toString(entity), HashMap.class);
      System.out.println(map.get("result"));
    } finally {
      response.close();
    }
  }

}
