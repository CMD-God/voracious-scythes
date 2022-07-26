package com.cmdgod.mc.voracious_scythes.gui;

import java.util.List;

import com.cmdgod.mc.voracious_scythes.VoraciousScythes;
import com.cmdgod.mc.voracious_scythes.items.PersonalDiscPlayer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.server.MinecraftServer;

public class PersonalDiscPlayerPropertyDelegate implements PropertyDelegate {

    ItemStack stack;
    static List<String> propertyNames = List.of("musicVolume", "currentTrack", "playMode");
    static List<Integer> defaultValues = List.of(100, 0, 0);
    public static final int SIZE = propertyNames.size();

    public PersonalDiscPlayerPropertyDelegate(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public int get(int index) {
        if (index >= size() || index < 0) {
            return -1;
        }
        String key = propertyNames.get(index);
        NbtCompound nbt = stack.getOrCreateNbt();
        if (nbt.contains(key)) {
            return nbt.getInt(key);
        }
        return defaultValues.get(index);
    }

    public int getByName(String name) {
        if (!propertyNames.contains(name)) {
            return -1;
        }
        return get(propertyNames.indexOf(name));
    }

    @Override
    public void set(int index, int value) {
        if (index >= size() || index < 0) {
            return;
        }
        String key = propertyNames.get(index);
        NbtCompound nbt = stack.getOrCreateNbt();
        nbt.putInt(key, value);
        //System.out.println(nbt);
        //System.out.println(stack);
    }

    public void setByName(String name, int value) {
        if (!propertyNames.contains(name)) {
            return;
        }
        set(propertyNames.indexOf(name), value);
    }

    @Override
    public int size() {
        return propertyNames.size();
    }
    
}
