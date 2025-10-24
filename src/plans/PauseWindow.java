package plans;

import interfaces.Pausable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PauseWindow implements Pausable {
    private final LocalDate from;
    private final LocalDate to;

    public PauseWindow(LocalDate from, LocalDate to) {
        if (to.isBefore(from)) {
            throw new IllegalArgumentException("Неверно выбрана дата");
        }
        this.from = from;
        this.to = to;
    }

    public int countsPauseDays() {
        return (int) ChronoUnit.DAYS.between(from, to) + 1;
    }

    @Override
    public void pause(LocalDate from, LocalDate to) {
    }

    @Override
    public boolean isPausedOn(LocalDate date) {
        return !date.isBefore(from) && !date.isAfter(to);
    }
}