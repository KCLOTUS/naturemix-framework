package cn.naturemix.framework;

/**
 * 提供相关配置项常量
 * @author flytoyou
 * @since 1.0.0
 */
public interface ConfigConstant {

    String CONFIG_FILE = "config.properties";

    String JDBC_DRIVER = "config.framework.jdbc.driver";
    String JDBC_URL="config.framework.jdbc.url";
    String JDBC_USERNAME="config.framework.jdbc.username";
    String JDBC_PASSWORD="config.framework.jdbc.password";

    String APP_BASE_PACKAGE="config.framework.app.base_package";
    String APP_JSP_PATH="config.framework.app.jsp_path";
    String APP_ASSET_PATH = "config.framework.app.asset_path";
    String APP_UPLOAD_LIMIT = "config.framework.upload_limit";

}
