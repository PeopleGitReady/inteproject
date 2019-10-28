public enum ArmorTypeRarity {

    COMMON(0,"COMMON"),
    RARE(14, "RARE"),
    EPIC(24, "EPIC");





    private final int ADDED_ARMOR_BONUS;
    private final String RARITY;

    ArmorTypeRarity(int armourBonus, String rarity){

        this.ADDED_ARMOR_BONUS=armourBonus;
        this.RARITY=rarity;

    }


    public int getArmorBonus(){
        return ADDED_ARMOR_BONUS;
    }
}
