package week1.week1Assignment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@Qualifier("chocolate_cake")
@ConditionalOnProperty(name = "cake",havingValue = "chocolate")
public class ChocolateCake implements Syrup,Frosting{
    @Override
    public String getFrosting() {
        return "Chocolate cake gets Frosting!!";
    }

    @Override
    public String getSyrup() {
        return "Chocolate cake gets Syrup!!";
    }


}
