package com.minmusxminmus.lovecraft.proxy.init;

import com.minmusxminmus.lovecraft.content.madness.IMadness;

public class ServerInitProxy implements IInitProxy
{
    @Override
    public void registerCapabilities() {
        IMadness.register();
    }
}
