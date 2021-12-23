package cc.fireflyhut.selftech;

import cc.fireflyhut.selftech.component.CommonBean;
import cc.fireflyhut.selftech.service.CommonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AspectTest {

//    @Autowired
//    private CommonBean commonBean;

    @Autowired
    private CommonService commonService;

//    @Test
//    public void testAspect() {
//        double sum = commonBean.add(1, 1);
//        commonBean.onlyAMethod();
//        System.out.println("\n\n");
//        System.out.println(sum);
//    }

    @Test
    public void testAspect1() {
        //System.out.println(commonService.getClass());
        //commonService.justRun("throw it away", "Run before they're finding me out");
        commonService.justRun("Just wanna run", 10, 0);
        //System.out.println(10.2 / 0.0);
    }



}
