package interfaces;

import java.time.LocalDate;

public interface Pausable {
    void pause(LocalDate from, LocalDate to); // прекратить подписку с from до to

    boolean isPausedOn(LocalDate date); // проверить, прекращена ли дата на момент времени
}