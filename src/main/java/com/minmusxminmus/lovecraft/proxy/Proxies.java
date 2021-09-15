package com.minmusxminmus.lovecraft.proxy;

import com.minmusxminmus.lovecraft.proxy.model.IModelProxy;
import net.minecraftforge.fml.common.SidedProxy;

public class Proxies {
    @SidedProxy(clientSide = "com.minmusxminmus.lovecraft.proxy.model.ClientModelProxy", serverSide = "com.minmusxminmus.lovecraft.proxy.model.ServerModelProxy")
    public static IModelProxy models;
    
}
