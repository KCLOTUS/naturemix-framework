package cn.naturemix.framework;

/**
 * 提供相关配置项常量
 * @author flytoyou
 * @since 1.0.0
 */
public interface ConfigConstant {

    String CONFIG_FILE = "config.properties";

    String JDBC_DRIVER = "config.frameework.jdbc.driver";
    String JDBC_URL="config.frameework.jdbc.url";
    String JDBC_USERNAME="config.frameework.jdbc.username";
    String JDBC_PASSWORD="config.frameework.jdbc.password";

    String APP_BASE_PACKAGE="config.frameework.app.base_package";
    String APP_JSP_PATH="config.frameework.app.jsp_path";
    String APP_ASSET_PATH = "config.frameework.app.asset_path";

}
