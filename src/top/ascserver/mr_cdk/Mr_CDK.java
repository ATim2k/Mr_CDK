package top.ascserver.mr_cdk;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

/**
 * Created by ZERO on 2017/1/3.
 */
public class Mr_CDK extends PluginBase implements Listener{
    public void onEnable(){
        saveResource("config.yml");
        this.getServer().getPluginManager().registerEvents(this,this);
        this.getLogger().info("§e插件加载成功,本插件作者Mr_sky,贴吧ID:贱哥啊哈哈,");
    }
    public boolean onCommand(CommandSender sender, Command command, String zhiling, String[] liebiao) {
        if (zhiling.equals("mrcdk")) {
            if (liebiao.length < 1){
                sender.sendMessage("[Mr_CDK]请输入/mrcdk 兑换码 以兑换物品");
                return false;
            }
            if (this.getConfig().get(liebiao[0]) != null) {
                String cmd = this.getConfig().get(liebiao[0]).toString();
                String cmdd = cmd.replace("{player}", sender.getName());
                this.getServer().dispatchCommand(new ConsoleCommandSender(), cmdd);
                this.getConfig().remove(liebiao[0]);
                this.getConfig().save();
                sender.sendMessage("[Mr_CDK]兑换成功，如果还没到帐，请重进服务器!");
            } else {
                sender.sendMessage("[Mr_CDK]兑换码不存在或已被使用!，请联系腐竹!");
            }
            return true;
        }
    return true;
    }
}
