package storage;

import entity.Operation;

import java.util.List;

public interface OperationStorage {
    public void save(Operation operation);
    public List<Operation> findAll();
}
