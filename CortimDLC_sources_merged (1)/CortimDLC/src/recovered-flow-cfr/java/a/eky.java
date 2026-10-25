/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Mouse
 *  net.minecraft.client.particle.ParticleManager
 *  net.minecraft.client.render.WorldRenderer
 *  net.minecraft.client.search.SearchManager
 *  net.minecraft.client.sound.SoundManager
 */
package a;

import a.ejl;
import a.ekj;
import a.ekm;
import a.ekp;
import a.eks;
import a.ekv;
import net.minecraft.client.Mouse;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.search.SearchManager;
import net.minecraft.client.sound.SoundManager;

final class eky {
    static final SoundManager SOUND = ejl.allocate(eks.class);
    static final ParticleManager PARTICLES = ejl.allocate(ekm.class);
    static final Mouse MOUSE = ejl.allocate(ekj.class);
    static final WorldRenderer WORLD_RENDERER = ejl.allocate(ekv.class);
    static final SearchManager SEARCH = ejl.allocate(ekp.class);
    private static /* synthetic */ String ekz;
    private static /* synthetic */ boolean ela;

    private eky() {
    }

    private static /* synthetic */ int gs(int n, int n2) {
        return (n ^ n2) + -385645329;
    }
}

