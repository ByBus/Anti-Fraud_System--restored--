package antifraud.buiseness;

public interface Converter<T, U> {
    U toDTO(T entity);

    T toEntity(U dto);
}