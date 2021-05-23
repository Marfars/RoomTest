package com.example.roomtest.core;

public class NetExceptionUtil {
    public final static String UnknownHost = "UnknownHostException";  //"域名解析失败"
    public final static String ConnectTimeout = "ConnectTimeoutException"; //"连接超时"
    public final static String SocketTimeout = "SocketTimeoutException"; //"socket 超时"
    public final static String HttpHostConnect = "HttpHostConnectException"; //"连接建立失败"
    public final static String NoRouteToHost = "NoRouteToHostException"; //"无法连接远程地址与端口"
    public final static String SSL = "SSLException";  //"SSL 失败"
    public final static String SSLHandshake = "SSLHandshakeException"; //"SSL/TLS 握手失败"
    public final static String SSLProtocol = "SSLProtocolException";  // "协议异常"
    public final static String NoHttpResponse = "NoHttpResponseException"; //"服务器响应异常"
    public final static String InterruptedIO = "InterruptedIOException";  //"IO 中断"
    public final static String IO = "IOException";  //"IO 失败"
    public final static String Socket = "SocketException";  //"Socket 异常"
    public final static String Connect = "ConnectException";  //"连接失败"
    public final static String Client = "ClientProtocolException";  //"协议错误"

    public static String getErrorMessage(String exception){
        String errMessage = "";
        switch (exception){
            case UnknownHost:
                errMessage =  "(10000)";
                break;
            case ConnectTimeout:
                errMessage = "(10001)";
                break;
            case SocketTimeout:
                errMessage = "(10002)";
                break;
            case HttpHostConnect:
                errMessage = "(10003)";
                break;
            case NoRouteToHost:
                errMessage = "(10004)";
                break;
            case SSL:
                errMessage = "(10005)";
                break;
            case SSLHandshake:
                errMessage = "(10006)";
                break;
            case SSLProtocol:
                errMessage = "(10007)";
                break;
            case NoHttpResponse:
                errMessage = "(10008)";
                break;
            case InterruptedIO:
                errMessage = "(10009)";
                break;
            case IO:
                errMessage = "(10010)";
                break;
            case Socket:
                errMessage = "(10011)";
                break;
            case Connect:
                errMessage = "(10012)";
                break;
            case Client:
                errMessage = "(10013)";
                break;
            default:
                errMessage = "";
                break;
        }
        return "网络开小差了" + errMessage;
    }
}
