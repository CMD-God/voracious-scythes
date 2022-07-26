package com.cmdgod.mc.voracious_scythes.gui;

import com.cmdgod.mc.voracious_scythes.VoraciousScythes;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;

public class ScythingTableGuiDescription extends SyncedGuiDescription {
    private static final int INVENTORY_SIZE = 1;

    public ScythingTableGuiDescription(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(VoraciousScythes.SCYTHING_TABLE_SCREEN_HANDLER_TYPE, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context));

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(300, 200);
        root.setInsets(Insets.ROOT_PANEL);

        WItemSlot itemSlot = WItemSlot.of(blockInventory, 0);
        root.add(itemSlot, 4, 1);

        root.add(this.createPlayerInventoryPanel(), 0, 3);

        root.validate(this);
    }
}
