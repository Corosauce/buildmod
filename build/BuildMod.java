package build;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;

import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@NetworkMod(channels = { "Data" }, clientSideRequired = true, serverSideRequired = true, packetHandler = BuildPacketHandler.class)
@Mod(modid = "BuildMod", name = "Build Mod", version = "v1.0")

public class BuildMod
{

    @SidedProxy(clientSide = "build.BuildClientProxy", serverSide = "build.BuildCommonProxy")
    public static BuildCommonProxy proxy;
    
    public Configuration preInitConfig;
    
    public ItemEditTool itemEditTool; 
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event)
    {
        preInitConfig = new Configuration(event.getSuggestedConfigurationFile());

        try
        {
            preInitConfig.load();
            
            //load here
        }
        catch (Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "SkeletonMod has a problem loading it's configuration");
        }
        finally
        {
            preInitConfig.save();
        }
    }
    
    @Init
    public void load(FMLInitializationEvent event)
    {
        proxy.init(this);
        proxy.registerRenderInformation();
        
        MinecraftForge.EVENT_BUS.register(new BuildEventHandler());
    }

    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event)
    {
        
    }
    
}


