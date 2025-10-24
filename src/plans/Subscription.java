package plans;

import java.time.LocalDate;

public abstract class Subscription {
    private static int countId = 0;
    private String id = String.valueOf(countId++);
    private String title;
    protected float monthlyPrice;
    private LocalDate startDate = LocalDate.now();
    protected boolean active;

    public Subscription(String title, float monthlyPrice, boolean active) {
        this.title = title;
        this.monthlyPrice = monthlyPrice;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getMonthlyPrice() {
        return monthlyPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public boolean isActive() {
        return active;
    }

    public void activate() {
        active = true;
    }

    public void cancel() {
        active = false;
    }

    public float price() {
        return monthlyPrice;
    }
}