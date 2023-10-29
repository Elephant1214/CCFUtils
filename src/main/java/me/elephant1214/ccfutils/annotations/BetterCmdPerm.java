package me.elephant1214.ccfutils.annotations;

import org.bukkit.permissions.PermissionDefault;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BetterCmdPerm {
    String value();

    PermissionDefault permDefault() default PermissionDefault.OP;
}
