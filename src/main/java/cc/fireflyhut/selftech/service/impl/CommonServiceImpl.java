package cc.fireflyhut.selftech.service.impl;

import cc.fireflyhut.selftech.service.CommonService;
import org.springframework.stereotype.Component;

@Component
public class CommonServiceImpl implements CommonService {

    @Override
    public String justRun(String someInfo, int someNum, int anotherNum) {
        int retNum = someNum / anotherNum;
        String ret = someInfo + " And " + retNum;
        System.out.println(ret);
        return ret;
    }

}
