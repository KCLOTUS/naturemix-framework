package cn.naturemix.framework.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet助手类
 * @author flytoyou
 * @version 1.0.0
 */
public class ServletHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServletHelper.class);

    /**
     * 使每个线程独自拥有一份ServletHelper实例
     */
    private static final ThreadLocal<ServletHelper> SERVLET_HELPER_THREAD = new ThreadLocal<ServletHelper>();

    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletHelper(HttpServletRequest request,HttpServletResponse response){
        this.request = request;
        this.response = response;
    }

    /**
     * 初始化
     */
    public static void init(HttpServletRequest request,HttpServletResponse response){
        SERVLET_HELPER_THREAD.set(new ServletHelper(request,response));
    }

    /**
     * 销毁
     */
    public static void destroy(){
        SERVLET_HELPER_THREAD.remove();
    }

    /**
     * 获取Request对象
     */
    public static HttpServletRequest getRequest(){
        return SERVLET_HELPER_THREAD.get().request;
    }

    /**
     * 获取Response对象
     */
    public static HttpServletResponse getResponse(){
        return SERVLET_HELPER_THREAD.get().response;
    }

    /**
     * 获取Session对象
     */
    public static HttpSession getSession(){
        return getRequest().getSession();
    }

    /**
     * 获取ServletContext对象
     */
    public static ServletContext getServletContext(){
        return getRequest().getServletContext();
    }

    /**
     * 将属性放入Request中
     */
    public static void setRequestAttribute(String key,Object value){
        getRequest().setAttribute(key,value);
    }

    /**
     * 从Request中获取属性
     */
    @SuppressWarnings("unchecked")
    public static <T> T getRequestAttribute(String key){
        return (T) getRequest().getAttribute(key);
    }

    /**
     * 从Request中移除属性
     */
    public static void removeRequestAttribute(String key){
        getRequest().removeAttribute(key);
    }

    /**
     * 发送重定向响应
     */
    public static void sendRedirect(String location){
        try{
            getResponse().sendRedirect(getRequest().getContextPath() + location);
        }catch (IOException e){
            LOGGER.error("redirect failure",e);
        }
    }

    /**
     * 将属性放入Session中
     */
    public static void setSessionAttribute(String key,Object value){
        getSession().setAttribute(key,value);
    }

    /**
     * 从Session中获取属性
     */
    @SuppressWarnings("unchecked")
    public static <T> T getSessionAttribute(String key){
        return (T) getRequest().getSession().getAttribute(key);
    }

    /**
     * 从Session中移除属性
     */
    public static void removeSessionAttribute(String key){
        getRequest().getSession().removeAttribute(key);
    }

    /**
     * 使用Session失效
     */
    public static void invalidateSession(){
        getRequest().getSession().invalidate();
    }

}