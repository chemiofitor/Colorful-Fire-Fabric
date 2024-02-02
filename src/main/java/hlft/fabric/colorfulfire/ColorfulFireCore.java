package hlft.fabric.colorfulfire;

import crystalspider.soulfired.api.Fire;
import crystalspider.soulfired.api.FireManager;
import hlft.fabric.colorfulfire.init.ColorfulFires;

import java.util.Objects;
import java.util.stream.Stream;

public class ColorfulFireCore {
    public static void init() {
        Stream.of(ColorfulFires.class.getDeclaredFields())
                .map(field -> {
                    try {
                        return field.get(null);
                    } catch (IllegalAccessException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .filter(Fire.class::isInstance)
                .map(o -> (Fire) o)
                .forEach(FireManager::registerFire);
    }
}
