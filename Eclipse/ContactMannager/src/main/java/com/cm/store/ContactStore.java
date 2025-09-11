package com.cm.store;

import com.cm.model.Contact;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ContactStore {
    private static final ContactStore INSTANCE = new ContactStore();

    private final ConcurrentHashMap<Integer, Contact> data = new ConcurrentHashMap<>();
    private final AtomicInteger idSeq = new AtomicInteger(1000);

    private ContactStore() {
        // Seed a couple of contacts so Sprint 2 shows "previous additional contacts"
        add(new Contact("Alice", "999-111-2222", "alice@example.com"));
        add(new Contact("Bob", "999-333-4444", "bob@example.com"));
    }

    public static ContactStore getInstance() {
        return INSTANCE;
    }

    public List<Contact> findAll() {
        List<Contact> list = new ArrayList<>(data.values());
        list.sort(Comparator.comparingInt(Contact::getId));
        return list;
    }

    public Contact findById(int id) {
        return data.get(id);
    }

    public Contact add(Contact c) {
        int id = idSeq.incrementAndGet();
        c.setId(id);
        data.put(id, c);
        return c;
    }

    public boolean update(Contact c) {
        int id = c.getId();
        if (!data.containsKey(id)) return false;
        data.put(id, c);
        return true;
    }

    public boolean delete(int id) {
        return data.remove(id) != null;
    }
}
