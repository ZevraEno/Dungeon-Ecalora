package be.dungeonEcalora.rolePlayGameManagement.dl.enums;

public enum Stats {
    FOR("Force"),
    DEX("Dexterité"),
    CON("Constitution"),
    INT("Intelligence"),
    SAG("Sagesse"),
    CHA("Charisme");

    public final String fullName;

    Stats(String fullName){
        this.fullName = fullName;
    }
}
