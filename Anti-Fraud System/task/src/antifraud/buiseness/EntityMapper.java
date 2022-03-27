package antifraud.buiseness;

public interface EntityMapper<D, E> {
    E toEntity(D dto);
}
