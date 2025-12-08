package week1.week1Assignment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@Qualifier("strawberry_cake")
@ConditionalOnProperty(name = "cake",havingValue = "strawberry")
public class StrawberryCake implements Frosting,Syrup{
    @Override
    public String getSyrup() {
        return "Strawberry cake gets syrup!!";
    }

    @Override
    public String getFrosting() {
        return "Strawberry cake gets frosting!!";
    }
}
