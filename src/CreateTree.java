import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by rachel on 18/08/19.
 */
public class CreateTree {

    public static void main(String[] args) {
        Bean snert = new Bean("Snert", Sex.FEMALE, Date.from(ZonedDateTime.now().minusYears(1).toInstant()), "Grey");
        System.out.println(snert.getName());
        Bean bert = new Bean("Bert", Sex.MALE, Date.from(ZonedDateTime.now().minusMonths(10).toInstant()), "Brown");
        snert.addMate(bert);
        System.out.println(snert.getMates());
        System.out.println(bert.getMates());
        Bean beeper = new Bean("Beeper", Sex.FEMALE, Date.from(ZonedDateTime.now().toInstant()), "Brown");
        snert.addPup(beeper);
        beeper.setFather(bert);
        System.out.println(beeper.getMother().getName());
        for (Bean bean : bert.getPups()) {
            System.out.println(bean.getName());
        }
    }
}


