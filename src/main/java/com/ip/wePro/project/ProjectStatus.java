package com.ip.wePro.project;

public enum ProjectStatus {
    SAVED,OPEN,CLOSE,IN_PROGRESS,COMPLETED;

    int value(){
        switch (this){
            case SAVED:
                return 0;
            case OPEN:
                return 1;
            case CLOSE:
                return 2;
            case IN_PROGRESS:
                return 3;
            case COMPLETED:
                return 4;
            default:
                throw new AssertionError("Unknown operation " + this);
        }
    }
}
