package plans;

import interfaces.Billable;
import interfaces.TrialSupport;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MusicPlan extends Subscription implements Billable, TrialSupport {
    private int trialDays = 14;

    public MusicPlan(String title, float monthlyPrice, boolean active) {
        super(title, monthlyPrice, active);
    }

    @Override
    public float monthlyCharge(LocalDate targetDate) {
        if (targetDate.isBefore(getStartDate())) {
            return 0;
        }
        long days = ChronoUnit.DAYS.between(getStartDate(), targetDate) + 1;
        float dayPrice = monthlyPrice / 30;
        return dayPrice * days;
    }

    @Override
    public int trialDays() {
        long daysPassed = ChronoUnit.DAYS.between(getStartDate(), LocalDate.now());
        int daysBeLeft = (int) (trialDays - daysPassed);
        return Math.max(daysBeLeft, 0);
    }

    @Override
    public boolean isInTrial() {
        return trialDays() > 0;
    }
}