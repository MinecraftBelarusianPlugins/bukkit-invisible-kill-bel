import org.bukkit.plugin.java.JavaPlugin;

public class EntryPoint extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager()
                .registerEvents(new KillListener(), this);
    }
}
