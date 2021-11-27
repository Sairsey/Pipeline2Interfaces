package com.java_polytech.pipeline_interfaces;

public interface IProvider {
    RC setConsumer(IConsumer consumer);

    TYPE[] getOutputTypes();

    IMediator getMediator(TYPE chosenType);
}
