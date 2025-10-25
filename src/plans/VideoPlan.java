package plans;

import homework_exception.EmptyMemberArrayException;
import homework_exception.MemberLimitExceededException;
import interfaces.Billable;
import interfaces.Pausable;
import interfaces.Sharable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class VideoPlan extends Subscription implements Billable, Pausable, Sharable {
    private int maxProfiles = 4;
    private String[] members = new String[maxProfiles];
    private PauseWindow[] pauses = new PauseWindow[5];
    private int countPauses = 0;
    private int countMembers = 0;

    public VideoPlan(String title, float monthlyPrice, boolean active) {
        super(title, monthlyPrice, active);
    }

    @Override
    public float monthlyCharge(LocalDate targetDate) {
        if (targetDate.isBefore(getStartDate())) {
            return 0;
        }
        int dayPauses = 0;
        if (countPauses > 0) {
            for (int i = 0; i < countPauses; i++) {
                dayPauses += pauses[i].countsPauseDays();
            }
        }
        long days = ChronoUnit.DAYS.between(getStartDate(), targetDate) + 1;
        days -= dayPauses;
        float dayPrice = monthlyPrice / 30;
        return dayPrice * days;
    }

    @Override
    public void pause(LocalDate from, LocalDate to) {
        if (countPauses >= pauses.length) {
            throw new IllegalArgumentException("Колличество пауз исчерпано");
        }
        PauseWindow pauseWindow = new PauseWindow(from, to);
        pauses[countPauses++] = pauseWindow;
    }

    @Override
    public boolean isPausedOn(LocalDate date) {
        for (PauseWindow pause : pauses) {
            if (pause != null && pause.isPausedOn(date)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int maxProfiles() {
        return maxProfiles;
    }

    @Override
    public void addMember(String userId) {
        if (countMembers >= maxProfiles) {
            throw new MemberLimitExceededException();
        }
        members[countMembers++] = userId;
    }

    @Override
    public void removeMember(String userId) {
        if (countMembers == 0) {
            throw new EmptyMemberArrayException();
        }
        for (int i = 0; i < countMembers; i++) {
            if (members[i].equalsIgnoreCase(userId)) {
                for (int j = i; j < countMembers - 1; j++) {
                    members[j] = members[j + 1];
                }
                members[countMembers - 1] = null;
                countMembers--;
                return;
            }
        }
        System.out.println("Пользователь не был найден");
    }
}