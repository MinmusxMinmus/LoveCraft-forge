package com.minmusxminmus.lovecraft.content.commands;

import com.minmusxminmus.lovecraft.content.madness.IMadness;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandMadness extends CommandBase {
    @Override
    public String getName() {
        return "Madness";
    }

    @Override
    public List<String> getAliases() {
        List<String> aliases = new ArrayList<>();
        Collections.addAll(aliases, "madness", "Mad", "mad");
        return aliases;
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "command.lovecraft.madness.usage";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {

        if (!sender.getCommandSenderEntity().hasCapability(IMadness.MADNESS_CAPABILITY, null)) {
            sender.sendMessage(new TextComponentString("Sender has no madness capability!"));
            return;
        }
        IMadness madness = sender.getCommandSenderEntity().getCapability(IMadness.MADNESS_CAPABILITY, null);

        // Double check, who knows
        if (madness == null) {
            sender.sendMessage(new TextComponentString("Sender has no madness capability!"));
            return;
        }

        if (args.length == 0) {
            sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.usage"));
            sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.specificHelp"));
            return;
        }

        switch (args[0]) {
            case "increase":
                if (args.length != 2) {
                    sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.increase.usage"));
                    break;
                }
                if (args[1].equals("help")) {
                    sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.increase.usage"));
                    sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.increase.help1"));
                    sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.increase.help2"));
                    sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.increase.help3"));
                    break;
                }
                try {
                    double val = Double.parseDouble(args[1]);
                    madness.increase(val);
                    madness.refresh();
                    sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.increase.increased1", val));
                    sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.increase.increased2", madness.getLevel()));
                } catch (Exception e) {
                    sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.increase.usage"));
                    sender.sendMessage(new TextComponentString("Exception: " + e));
                }
                break;
            case "reset":
                if (args.length > 2 && args[1].equals("help")) {
                    sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.reset.usage"));
                    sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.reset.help1"));
                    sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.reset.help2"));
                }
                madness.setMin();
                madness.refresh();
                sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.reset.reset", madness.getLevel()));
                break;
            case "level":
                if (args.length > 2 && args[1].equals("help")) {
                    sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.reset.usage"));
                    sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.reset.help1"));
                    sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.reset.help2"));
                }
                sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.level.level", madness.getLevel()));
                break;
            case "help":
                sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.usage"));
                sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.help1"));
                sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.help2"));
                sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.specificHelp"));
                break;
            default:
                sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.usage"));
                sender.sendMessage(new TextComponentTranslation("command.lovecraft.madness.specificHelp"));
        }
    }
}
