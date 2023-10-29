package me.elephant1214.ccfutils.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation for multiple {@link BetterCmdPerm}s so that you can have
 * multiple permissions for one command. E.g., a permission that gives players
 * access to all commands and a permission that is exclusive to the command.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MultipleCmdPerms {
    /**
     * @return The permissions for the command
     */
    BetterCmdPerm[] value();
}
