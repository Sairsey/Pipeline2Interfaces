package com.java_polytech.pipeline_interfaces;

public class RC {

    public enum RCType {
        // for Reader, Writer, Executor and Manager
        CODE_SUCCESS,
        CODE_CUSTOM_ERROR,

        // for Manager
        CODE_INVALID_ARGUMENT,
        CODE_FAILED_PIPELINE_CONSTRUCTION,

        // for Manager
        CODE_INVALID_INPUT_FILE,
        CODE_INVALID_OUTPUT_FILE,

        // for Reader, Writer, Executor and Manager
        CODE_CONFIG_FILE_ERROR,
        CODE_CONFIG_GRAMMAR_ERROR,
        CODE_CONFIG_SEMANTIC_ERROR,
        CODE_TYPES_INTERSECTION_EMPTY_ERROR,

        // for Reader
        CODE_FAILED_TO_READ,

        // for Writer
        CODE_FAILED_TO_WRITE,
    }

    public enum RCWho {
        UNKNOWN("UNKNOWN"),
        READER("READER"),
        EXECUTOR("EXECUTOR"),
        WRITER("WRITER"),
        MANAGER("MANAGER");
        final private String who;

        RCWho(String owner)
        {
            who = owner;
        }
        public String get()
        {
            return who;
        }
    }

    public final RCType type;
    public final String info;
    public final RCWho who;

    public RC(RCWho who, RCType type, String info)
    {
        this.who = who;
        this.type = type;
        this.info = info;
    }

    public boolean isSuccess(){
        return type == RCType.CODE_SUCCESS;
    }

    public static final RC RC_SUCCESS = new RC(RCWho.UNKNOWN, RCType.CODE_SUCCESS, "No errors have occurred.");

    public static final RC RC_MANAGER_INVALID_ARGUMENT = new RC(RCWho.MANAGER, RCType.CODE_INVALID_ARGUMENT, "Invalid argument for manager.");
    public static final RC RC_MANAGER_INVALID_READER_CLASS = new RC(RCWho.MANAGER, RCType.CODE_FAILED_PIPELINE_CONSTRUCTION, "Couldn't find valid IReader class.");
    public static final RC RC_MANAGER_INVALID_WRITER_CLASS = new RC(RCWho.MANAGER, RCType.CODE_FAILED_PIPELINE_CONSTRUCTION, "Couldn't find valid IWriter class.");
    public static final RC RC_MANAGER_INVALID_EXECUTOR_CLASS = new RC(RCWho.MANAGER, RCType.CODE_FAILED_PIPELINE_CONSTRUCTION, "Couldn't find valid IExecutor class.");
    public static final RC RC_MANAGER_INVALID_INPUT_FILE = new RC(RCWho.MANAGER, RCType.CODE_INVALID_INPUT_FILE, "Couldn't open input file.");
    public static final RC RC_MANAGER_INVALID_OUTPUT_FILE = new RC(RCWho.MANAGER, RCType.CODE_INVALID_OUTPUT_FILE, "Couldn't open output file.");
    public static final RC RC_MANAGER_CONFIG_FILE_ERROR = new RC(RCWho.MANAGER, RCType.CODE_CONFIG_FILE_ERROR, "Couldn't open manager config file.");
    public static final RC RC_MANAGER_CONFIG_GRAMMAR_ERROR = new RC(RCWho.MANAGER, RCType.CODE_CONFIG_GRAMMAR_ERROR, "Some grammar error in manager config file.");
    public static final RC RC_MANAGER_CONFIG_SEMANTIC_ERROR = new RC(RCWho.MANAGER, RCType.CODE_CONFIG_SEMANTIC_ERROR, "Some semantic error in manager config file.");

    public static final RC RC_READER_CONFIG_FILE_ERROR = new RC(RCWho.READER, RCType.CODE_CONFIG_FILE_ERROR, "Couldn't open reader config file.");
    public static final RC RC_READER_CONFIG_GRAMMAR_ERROR = new RC(RCWho.READER, RCType.CODE_CONFIG_GRAMMAR_ERROR, "Some grammar error in reader config file.");
    public static final RC RC_READER_CONFIG_SEMANTIC_ERROR = new RC(RCWho.READER, RCType.CODE_CONFIG_SEMANTIC_ERROR, "Some semantic error in reader config file.");
    public static final RC RC_READER_FAILED_TO_READ = new RC(RCWho.READER, RCType.CODE_FAILED_TO_READ, "Some input error has occurred while reading from input file.");

    public static final RC RC_WRITER_TYPES_INTERSECTION_EMPTY_ERROR = new RC(RCWho.EXECUTOR, RCType.CODE_CONFIG_FILE_ERROR, "Intersection between provider`s output types and my input types are empty");
    public static final RC RC_WRITER_CONFIG_FILE_ERROR = new RC(RCWho.WRITER, RCType.CODE_CONFIG_FILE_ERROR, "Couldn't open writer config file.");
    public static final RC RC_WRITER_CONFIG_GRAMMAR_ERROR = new RC(RCWho.WRITER, RCType.CODE_CONFIG_GRAMMAR_ERROR, "Some grammar error in writer config file.");
    public static final RC RC_WRITER_CONFIG_SEMANTIC_ERROR = new RC(RCWho.WRITER, RCType.CODE_CONFIG_SEMANTIC_ERROR, "Some semantic error in writer config file.");
    public static final RC RC_WRITER_FAILED_TO_WRITE = new RC(RCWho.WRITER, RCType.CODE_FAILED_TO_WRITE, "Some output error has occurred while writing to output file.");

    public static final RC RC_EXECUTOR_TYPES_INTERSECTION_EMPTY_ERROR = new RC(RCWho.EXECUTOR, RCType.CODE_CONFIG_FILE_ERROR, "Intersection between provider`s output types and my input types are empty");
    public static final RC RC_EXECUTOR_CONFIG_FILE_ERROR = new RC(RCWho.EXECUTOR, RCType.CODE_CONFIG_FILE_ERROR, "Couldn't open executor config file.");
    public static final RC RC_EXECUTOR_CONFIG_GRAMMAR_ERROR = new RC(RCWho.EXECUTOR, RCType.CODE_CONFIG_GRAMMAR_ERROR, "Some grammar error in executor config file.");
    public static final RC RC_EXECUTOR_CONFIG_SEMANTIC_ERROR = new RC(RCWho.EXECUTOR, RCType.CODE_CONFIG_SEMANTIC_ERROR, "Some semantic error in executor config file.");

}
