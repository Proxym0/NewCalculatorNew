package storage;

import entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOperationStorage {

List<Operation> store = new ArrayList<>();

void save(Operation operation){
        store.add(operation);
}
}