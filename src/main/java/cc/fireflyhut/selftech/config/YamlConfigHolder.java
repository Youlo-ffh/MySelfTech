package cc.fireflyhut.selftech.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "user")  // 对应yml文件最外层节点，即user节点
public class YamlConfigHolder {
    // 对应user节点内的username节点
    private String username;
    // 同上
    private List<String> grants;

    private Map<String, Object> info;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getGrants() {
        return grants;
    }

    public void setGrants(List<String> grants) {
        this.grants = grants;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "YamlConfigHolder{" +
                "username='" + username + '\'' +
                ", grants=" + grants +
                ", info=" + info +
                '}';
    }
}
