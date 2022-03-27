package antifraud.buiseness;

public interface Converter<E, D> extends DTOMapper<E, D>, EntityMapper<D, E> { }