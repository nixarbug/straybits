package com.nixrstudios.computationapi.common.event;

import com.nixrstudios.computationapi.common.model.Event;

public interface EventPublisher<T extends Event> {
    void publish(T event);
}
