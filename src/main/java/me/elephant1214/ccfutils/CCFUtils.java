package me.elephant1214.ccfutils;

import cloud.commandframework.annotations.AnnotationParser;
import cloud.commandframework.permission.CommandPermission;
import cloud.commandframework.permission.OrPermission;
import me.elephant1214.ccfutils.annotations.BetterCmdPerm;
import me.elephant1214.ccfutils.annotations.MultipleCmdPerms;
import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;

import java.util.ArrayList;

public final class CCFUtils {
    public static void registerAnnotations(AnnotationParser<?> annotationParser) {
        annotationParser.registerBuilderModifier(BetterCmdPerm.class, (annotation, builder) -> {
            Permission perm = Bukkit.getPluginManager().getPermission(annotation.value());
            if (perm == null) {
                Bukkit.getPluginManager().addPermission(new Permission(annotation.value(), annotation.permDefault()));
            }
            return builder.permission(cloud.commandframework.permission.Permission.of(annotation.value()));
        });

        annotationParser.registerBuilderModifier(MultipleCmdPerms.class, (annotation, builder) -> {
            final var perms = new ArrayList<CommandPermission>();
            for (BetterCmdPerm bcp : annotation.value()) {
                perms.add(cloud.commandframework.permission.Permission.of(bcp.value()));
            }
            return builder.permission(OrPermission.of(perms));
        });
    }
}
