package codes.shawlas.data;

import codes.shawlas.data.exception.MessageExecutionException;
import codes.shawlas.data.exception.MessageSendingException;
import org.jetbrains.annotations.NotNull;

public sealed interface Request permits Request.Input, Request.Output {

    @NotNull Object getId();

    @NotNull Object getCode();

    @NotNull Message getMessage();

    void finish();

    // Classes

    non-sealed interface Input extends Request {

        @Override
        @NotNull Message.Input getMessage();

        void execute(@NotNull Object @NotNull ... args) throws MessageExecutionException;

    }

    non-sealed interface Output extends Request {

        @Override
        @NotNull Message.Output getMessage();

        void send(@NotNull Object @NotNull ... args) throws MessageSendingException;

    }
}
