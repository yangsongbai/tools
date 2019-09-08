package com.dingding.alarm;

import com.dingding.alarm.tools.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

;

/**
 * @author yangsongbai
 * @projectName lcmp
 * @packageName com.xes.logCenter.net
 * @className HttpUtil
 * @dateTime 2018/9/12 17:29
 */
public class HttpUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    static URL dingUrl = null;// 创建url资源
    static  HttpURLConnection conn = null;// 建立http连接

    @SuppressWarnings("unchecked")
    public static  void postDingDing(String content,String url) throws Exception {
        OutputStreamWriter out =null;
        try {
            dingUrl = new URL(url);
            conn = (HttpURLConnection) dingUrl.openConnection();
            conn.setDoOutput(true);// 设置允许输出
            conn.setDoInput(true);// 设置允许输入
            conn.setUseCaches(false);// 设置不用缓存
            conn.setRequestMethod("POST");// 设置传参方式
            String utf8 = "UTF-8";
            conn.setRequestProperty("Charset", utf8);
            conn.setRequestProperty("Accept","application/json");
            //conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Type", " application/json;charset="+utf8);
          /*  conn.setRequestProperty("Content-Type", " application/x-www-form-urlencoded;"+utf8);*/
            conn.connect();// 开始连接请求
            out = new OutputStreamWriter(conn.getOutputStream(),utf8);
            out.write(content);
            out.flush();
            out.close();
            int responseCode = conn.getResponseCode();
            InputStream inputStream = conn.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));//这里可以用这个也可以直接用流，buffer的话就是多了个缓存功能
            int c = 0;
            StringBuffer temp = new StringBuffer();//请求接口获取json拼接字符串的话，比较长的返回结果String接收是不够的
            while((c = rd.read())!= -1){//这里可以用read也可用readLine，不清楚的话可以查一下两者区别
                temp.append((char)c);
            }
            System.out.println("返回内容："+temp);
        } catch (Exception e) {
            logger.error(DateUtil.getTodayDate("yyyy-MM-dd HH:mm:ss")+" "+e.getMessage());
            System.out.println("发送POST请求出现异常！" + e);
            if (out!=null)
                out.close();
        }finally {
            if (conn!=null)conn.disconnect();
        }
    }
    public static String getContent(String urlString,int connectTimeOut,int readTimeOut) {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(connectTimeOut);
            connection.setReadTimeout(readTimeOut);
            // 发送请求
            connection.connect();
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                // 封装输入流is，并指定字符集
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                // 存放数据
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
            return result;
        } catch (MalformedURLException e) {
            //e.printStackTrace();
            logger.error(e.getMessage());
        } catch (IOException e) {
            //e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            connection.disconnect();// 关闭远程连接
        }

        return "";
    }
    public static String doGet(String httpurl,int connectTimeOut,int readTimeOut) {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;// 返回结果字符串
        try {
            // 创建远程url连接对象
            URL url = new URL(httpurl);
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            connection.setRequestMethod("GET");
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(connectTimeOut);
            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(readTimeOut);
            // 发送请求
            connection.connect();
            // 通过connection连接，获取输入流
          /*  if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                // 封装输入流is，并指定字符集
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                // 存放数据
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }*/
            return connection.getResponseCode()+"";
        } catch (MalformedURLException e) {
            //e.printStackTrace();
            logger.error(e.getMessage());
        } catch (IOException e) {
            //e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            connection.disconnect();// 关闭远程连接
        }

        return "";
    }
}
