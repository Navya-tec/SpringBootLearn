package week1.week1Assignment;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {

    private Frosting f;
    private  Syrup s;

    //constructor injection
    CakeBaker(Frosting f, Syrup s){
        this.f=f;
        this.s=s;
    }
    public String bakeCake(){
        return s.getSyrup()+" "+f.getFrosting();
    }

    @PostConstruct
    void beforeBaking(){
        System.out.println("Baker prepares the batter");
    }

    @PreDestroy
    void eatCake(){
        System.out.println("Cake is eaten!");
    }
}
