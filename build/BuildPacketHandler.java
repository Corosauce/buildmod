package build;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class BuildPacketHandler implements IPacketHandler
{
    public BuildPacketHandler()
    {
    }

    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
    {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(packet.data));

        if ("Data".equals(packet.channel))
        {
            try
            {
                //float val = dis.readFloat();
                
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
