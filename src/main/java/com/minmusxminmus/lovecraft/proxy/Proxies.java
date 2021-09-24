package com.minmusxminmus.lovecraft.proxy;

import com.minmusxminmus.lovecraft.proxy.init.IInitProxy;
import com.minmusxminmus.lovecraft.proxy.model.IModelProxy;
import net.minecraftforge.fml.common.SidedProxy;

public class Proxies {
    @SidedProxy(clientSide = "com.minmusxminmus.lovecraft.proxy.model.ClientModelProxy", serverSide = "com.minmusxminmus.lovecraft.proxy.model.ServerModelProxy")
    public static IModelProxy models;

    @SidedProxy(clientSide = "com.minmusxminmus.lovecraft.proxy.init.ClientInitProxy", serverSide = "com.minmusxminmus.lovecraft.proxy.init.ServerInitProxy")
    public static IInitProxy initialization;
    
}
