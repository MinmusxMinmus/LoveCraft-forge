package com.minmusxminmus.lovecraft.content.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CommandLoveCraft extends CommandBase {
    @Override
    public String getName() {
        return "LoveCraft";
    }

    @Override
    public List<String> getAliases() {
        List<String> aliases = new ArrayList<>();
        Collections.addAll(aliases, "lovecraft");
        return aliases;
    }



    @Override
    public String getUsage(ICommandSender sender) {
        return "command.lovecraft.lovecraft.usage";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        sender.sendMessage(new TextComponentString("Hello from /LoveCraft"));
    }
}
