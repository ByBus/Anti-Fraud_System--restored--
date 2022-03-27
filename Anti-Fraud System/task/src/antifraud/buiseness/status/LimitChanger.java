package antifraud.buiseness.status;

import antifraud.persistance.StatusRepositoryService;
import antifraud.persistance.entity.TransactionStatusEntity;

public abstract class LimitChanger {
    private final StatusRepositoryService statusRepository;
    private final TransactionStatus status;
    private LimitChanger next;
    private static final int DECREASE_LIMIT_VALUE = 1;
    private static final int INCREASE_LIMIT_VALUE = 2;

    public LimitChanger(StatusRepositoryService statusRepository, TransactionStatus status) {
        this.statusRepository = statusRepository;
        this.status = status;
    }

    public LimitChanger setNextLimitChanger(LimitChanger next) {
        this.next = next;
        return this.next;
    }

    private void changeLimitIfStatusDESCDirection(TransactionStatus from, TransactionStatus to, long transactionAmount) {
        if (status.getPriority() < from.getPriority() && status.getPriority() >= to.getPriority()) {
            updateLimit(transactionAmount, INCREASE_LIMIT_VALUE);
        }
        if (next != null) {
            next.changeLimitIfStatusDESCDirection(from, to, transactionAmount);
        }
    }

    private void changeLimitIfStatusASCDirection(TransactionStatus from, TransactionStatus to, long transactionAmount) {
        if (status.getPriority() >= from.getPriority() && status.getPriority() < to.getPriority()) {
            updateLimit(transactionAmount, DECREASE_LIMIT_VALUE);
        }
        if (next != null) {
            next.changeLimitIfStatusASCDirection(from, to, transactionAmount);
        }
    }

    private void updateLimit(long transactionAmount, int limitOperationType) {
        TransactionStatusEntity current = statusRepository.get(status);
        long newLimit = limitOperationType == DECREASE_LIMIT_VALUE
                ? calculateDecreasedLimit(current.getMaxAmount(), transactionAmount)
                : calculateIncreasedLimit(current.getMaxAmount(), transactionAmount);
        current.setMaxAmount(newLimit);
        statusRepository.update(current);
    }

    public void changeLimit(TransactionStatus from, TransactionStatus to, long transactionAmount) {
        if (from.getPriority() > to.getPriority()) {
            changeLimitIfStatusDESCDirection(from, to, transactionAmount);
        }
        if (from.getPriority() < to.getPriority()) {
            changeLimitIfStatusASCDirection(from, to, transactionAmount);
        }
    }

    abstract long calculateIncreasedLimit(long oldAmount, long amount);

    abstract long calculateDecreasedLimit(long oldAmount, long amount);
}
