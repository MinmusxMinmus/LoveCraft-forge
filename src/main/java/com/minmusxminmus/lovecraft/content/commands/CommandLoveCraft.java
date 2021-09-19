package com.minmusxminmus.lovecraft.content.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CommandLoveCraft extends CommandBase {
    @Override
    public String getName() {
        return "LoveCraft";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.lovecraft.lovecraft.usage";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        sender.sendMessage(new TextComponentString("Hello from /LoveCraft"));
    }
}
