package org.goldcraftmc.Paintball;

import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import mc.alk.arena.objects.arenas.Arena;
import mc.alk.arena.objects.events.ArenaEventHandler;

public class PaintballArena extends Arena {
	static int damage = 20;

	@ArenaEventHandler(suppressCastWarnings = true)
	public void onEntityDamage(EntityDamageEvent event) {
		if (event.isCancelled()
				|| !(event instanceof EntityDamageByEntityEvent)
				|| ((EntityDamageByEntityEvent) event).getDamager().getType() != EntityType.SNOWBALL)
			return;
		event.setDamage(damage);
	}
}