package hlft.fabric.colorfulfire.init;

import crystalspider.soulfired.api.Fire;
import crystalspider.soulfired.api.FireBuilder;
import crystalspider.soulfired.api.FireManager;

import static hlft.fabric.colorfulfire.ColorfulFire.id;

public class ColorfulFires {
    public static final Fire AQUAMARINE_FIRE = newBuilder("aquamarine").build();
    public static final Fire INDIGO_FIRE = newBuilder("indigo").build();
    public static final Fire DARKBLUE_FIRE = newBuilder("darkblue").build();

    public static FireBuilder newBuilder(String id) {
        return FireManager.fireBuilder(id(id))
                .setDamage(2)
                .setFireAspectConfig(builder -> builder.setEnabled(() -> true))
                .setFlameConfig(builder -> builder.setEnabled(() -> true))
                .setInFire();
    }
}
