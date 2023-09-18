import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffectType;

public class KillListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        var player = e.getEntity();
        var killer = player.getKiller();

        var isPlayerInvisible = player.hasPotionEffect(PotionEffectType.INVISIBILITY);
        var isKillerInvisible = killer != null && killer.hasPotionEffect(PotionEffectType.INVISIBILITY);

        if (killer == null || (!isPlayerInvisible && !isKillerInvisible)) {
            return;
        }

        if (isPlayerInvisible && isKillerInvisible) {
            e.setDeathMessage("");
        } else if (isKillerInvisible) {
            e.setDeathMessage("Гулец " + player.getName() + " быў забіты кімсьці");
        } else {
            e.setDeathMessage("Нехта быў забіты гульцом " + killer.getName());
        }
    }
}
