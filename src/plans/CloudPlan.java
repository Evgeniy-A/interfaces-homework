package plans;

import interfaces.Billable;
import java.time.LocalDate;

public class CloudPlan extends Subscription implements Billable {
    private int storageTb;
    public int baseTbPrice;
    public int extraTbPrice;

    public CloudPlan(String title, float monthlyPrice,
                     boolean active, int storageTb) {
        super(title, monthlyPrice, active);
        this.storageTb = storageTb;
    }

    @Override
    public float monthlyCharge(LocalDate targetDate) {
        if (storageTb <= 1) {
            return baseTbPrice;
        }
        int extraTb = storageTb - 1;
        return baseTbPrice + (extraTb * extraTbPrice);
    }
}
