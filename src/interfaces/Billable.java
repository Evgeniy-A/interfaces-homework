package interfaces;

import java.time.LocalDate;

public interface Billable {
    float monthlyCharge(LocalDate targetDate); // расчёт списания за месяц (с учётом статуса/скидок)
}