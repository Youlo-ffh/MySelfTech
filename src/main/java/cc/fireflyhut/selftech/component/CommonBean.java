package cc.fireflyhut.selftech.component;

import org.springframework.stereotype.Component;

@Component
public class CommonBean {

    public double add(int i, int j) {
        System.out.println("method start running");
        double sum = i / j;
        System.out.println("method end run");
        return sum;
    }

    public void onlyAMethod() {
        System.out.println("only a method...");
    }

}
