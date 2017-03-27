package no.fint.model.relation;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public enum RelationUtil {
    ;

    public static List<String> getRelationTypes(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> field.getType() == String.class && Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers()))
                .map(field -> {
                    try {
                        return (String) field.get(null);
                    } catch (IllegalAccessException e) {
                        log.warn("Unable to access field {}, {}", field.getName(), e.getMessage());
                        return "";
                    }
                }).collect(Collectors.toList());
    }

    public static Optional<String> getConstantValue(Class<?> clazz, String method) {
        try {
            return Optional.ofNullable((String) clazz.getDeclaredField(method).get(null));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            log.warn("Unable to access constant {}.{}, {}", clazz.getSimpleName(), method, e.getMessage());
            return Optional.empty();
        }
    }

}
