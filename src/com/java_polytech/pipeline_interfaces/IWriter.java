package com.java_polytech.pipeline_interfaces;

import java.io.OutputStream;

public interface IWriter extends IConsumer, IConfigurable {
    RC setOutputStream(OutputStream output);
}
