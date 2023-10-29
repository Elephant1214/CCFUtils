package me.elephant1214.ccfutils.annotations;

import org.bukkit.permissions.PermissionDefault;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An alternative to {@link cloud.commandframework.annotations.CommandPermission} that
 * allows you to specify a {@link PermissionDefault}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BetterCmdPerm {
    /**
     * @return The actual permission
     */
    String value();

    /**
     * @return The default value for the permission
     */
    PermissionDefault permDefault() default PermissionDefault.OP;
}
