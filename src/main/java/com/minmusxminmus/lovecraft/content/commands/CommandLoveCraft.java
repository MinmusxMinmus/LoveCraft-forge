package com.minmusxminmus.lovecraft.content.commands;

import com.minmusxminmus.lovecraft.content.madness.IMadness;
import com.minmusxminmus.lovecraft.content.madness.PlayerMadness;
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
        sender.sendMessage(new TextComponentString("Arguments: " + Arrays.toString(args)));
        if (args.length != 0) {
            switch (args[0]) {
                case "capability":
                    sender.sendMessage(new TextComponentString(
                            "Has madness capability? " +
                                    sender.getCommandSenderEntity().hasCapability(IMadness.MADNESS_CAPABILITY, null)));
                    break;
                case "madness":
                    if (!sender.getCommandSenderEntity().hasCapability(IMadness.MADNESS_CAPABILITY, null)) {
                        sender.sendMessage(new TextComponentString("Sender has no madness capability!"));
                        break;
                    }
                    IMadness madness = sender.getCommandSenderEntity().getCapability(IMadness.MADNESS_CAPABILITY, null);

                    if (args.length != 1) {
                        switch (args[1]) {
                            case "increase":
                                if (args.length != 3) {
                                    sender.sendMessage(new TextComponentString("Usage: /LoveCraft madness increase <value>"));
                                    break;
                                }
                                try {
                                    double val = Double.parseDouble(args[2]);

                                    madness.increase(val);
                                    madness.refresh();
                                    sender.sendMessage(new TextComponentString("Increases madness value by " + val));
                                } catch (Exception e) {
                                    sender.sendMessage(new TextComponentString("Usage: /LoveCraft madness increase <value>"));
                                    sender.sendMessage(new TextComponentString("Exception: " + e));
                                }
                                break;
                        }
                        break;
                    }

                    sender.sendMessage(new TextComponentString("Current madness level: " + madness.getLevel()));
                    sender.sendMessage(new TextComponentString("Is player madness? " + (madness instanceof PlayerMadness)));
            }
        }
    }

}
