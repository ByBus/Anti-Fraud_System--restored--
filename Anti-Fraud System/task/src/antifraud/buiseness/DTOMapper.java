package antifraud.buiseness;

public interface DTOMapper<E, D> {
    D toDTO(E entity);
}
