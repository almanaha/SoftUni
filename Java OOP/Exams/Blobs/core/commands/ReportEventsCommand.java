package core.commands;

import annotation.Inject;
import interfaces.Executable;
import utility.MutateBoolean;

public class ReportEventsCommand implements Executable {
    @Inject
    private MutateBoolean mutateBoolean;

    @Override
    public void execute() {
        this.mutateBoolean.setFlag(true);
    }
}
