package cc.fireflyhut.selftech;

import cc.fireflyhut.selftech.component.CommonBean;
import cc.fireflyhut.selftech.config.YamlConfigHolder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SelfTechApplicationTests {

    @Autowired
    CommonBean commonBean;

    @Autowired
    private YamlConfigHolder yamlConfigHolder;

    @Test
    public void testAspect() {
        double sum = commonBean.add(10, 15);
        System.out.println(sum);
    }

    @Test
    public void testGetValueFromYaml() {
        System.out.println(yamlConfigHolder);
    }
}
