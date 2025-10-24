import plans.CloudPlan;
import plans.MusicPlan;
import plans.PauseWindow;
import plans.VideoPlan;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // === Видео-подписка ===
        System.out.println("=== VIDEO PLAN ===");
        VideoPlan videoPlan = new VideoPlan("Netflix Premium", 300, true);
        videoPlan.addMember("user1");
        videoPlan.addMember("user2");

        System.out.println("Максимум профилей: " + videoPlan.maxProfiles());
        System.out.println("Пауза подписки...");
        videoPlan.pause(LocalDate.now().plusDays(5), LocalDate.now().plusDays(10));
        System.out.println("Проверка паузы на 7-й день: " + videoPlan.isPausedOn(LocalDate.now().plusDays(7)));
        System.out.println("Проверка паузы на 15-й день: " + videoPlan.isPausedOn(LocalDate.now().plusDays(15)));

        float videoCharge = videoPlan.monthlyCharge(LocalDate.now().plusDays(30));
        System.out.println("Стоимость видео-подписки за месяц (с учётом пауз): " + videoCharge + " руб.");

        System.out.println("Удаление участника...");
        videoPlan.removeMember("user1");
        System.out.println("Участник user1 удалён.\n");

        // === Музыкальная подписка ===
        System.out.println("=== MUSIC PLAN ===");
        MusicPlan musicPlan = new MusicPlan("Spotify", 200, true);
        System.out.println("Осталось дней пробного периода: " + musicPlan.trialDays());
        System.out.println("В пробном периоде? " + musicPlan.isInTrial());
        float musicCharge = musicPlan.monthlyCharge(LocalDate.now().plusDays(10));
        System.out.println("Сумма к списанию: " + musicCharge + " руб.\n");

        // === Облачная подписка ===
        System.out.println("=== CLOUD PLAN ===");
        CloudPlan cloudPlan = new CloudPlan("Google Drive", 0, true, 3);
        // так как у Тебя поля baseTbPrice и extraTbPrice приватные — сделай их package-private или добавь сеттеры
        // для примера присвоим значения напрямую, если поля публичные
        cloudPlan.baseTbPrice = 500;
        cloudPlan.extraTbPrice = 200;

        float cloudCharge = cloudPlan.monthlyCharge(LocalDate.now());
        System.out.println("Стоимость облака: " + cloudCharge + " руб. (за " + 3 + " ТБ)\n");

        // === Проверка паузы напрямую ===
        System.out.println("=== PAUSE WINDOW ===");
        PauseWindow pause = new PauseWindow(LocalDate.now(), LocalDate.now().plusDays(3));
        System.out.println("Количество дней паузы: " + pause.countsPauseDays());
        System.out.println("Дата " + LocalDate.now().plusDays(2) + " входит в паузу? " + pause.isPausedOn(LocalDate.now().plusDays(2)));
        System.out.println("Дата " + LocalDate.now().plusDays(5) + " входит в паузу? " + pause.isPausedOn(LocalDate.now().plusDays(5)));
    }
}