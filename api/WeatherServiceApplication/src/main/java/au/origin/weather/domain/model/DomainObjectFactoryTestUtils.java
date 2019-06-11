package au.origin.weather.domain.model;

public final class DomainObjectFactoryTestUtils {

    private DomainObjectFactoryTestUtils() {
    }

    public static <T> T create(Class<T> type) {

        try {

            return type.newInstance();

        } catch (InstantiationException | IllegalAccessException e) {

            throw new RuntimeException(e);
        }
    }

}
