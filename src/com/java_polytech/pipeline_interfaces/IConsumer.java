package com.java_polytech.pipeline_interfaces;

public interface IConsumer {
    RC setProvider(IProvider provider);

    RC consume();
}

