package interfaces;

// интерфейс для предоставления доступа людям к подписке
public interface Sharable {
    int maxProfiles();

    void addMember(String userId);

    void removeMember(String userId);
}