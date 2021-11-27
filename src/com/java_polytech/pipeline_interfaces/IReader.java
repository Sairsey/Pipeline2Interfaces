package com.java_polytech.pipeline_interfaces;

import java.io.InputStream;

public interface IReader extends IProvider, IConfigurable {
    RC setInputStream(InputStream input);

    RC run();
}
