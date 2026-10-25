/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.MapColor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.decoration.ItemFrameEntity
 *  net.minecraft.item.FilledMapItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.map.MapState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 */
package a;

import flow.dev.a;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.imageio.ImageIO;
import net.minecraft.block.MapColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.map.MapState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class enq {
    private static final int enr = 128;
    private static final int ens = 16;
    private static final int ent = 4;
    public static final double SHUFFLED_SEAMS = 2.0;
    private static /* synthetic */ int enu;
    private static /* synthetic */ int env;

    private enq() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static BufferedImage capture(ItemFrameEntity itemFrameEntity2) {
        Object object;
        World world = itemFrameEntity2.getEntityWorld();
        Direction direction = itemFrameEntity2.getHorizontalFacing();
        if (direction.getAxis() == Direction.Axis.Y || !(itemFrameEntity2.getHeldItemStack().getItem() instanceof FilledMapItem)) {
            return null;
        }
        boolean bl = direction.getAxis() == Direction.Axis.Z;
        boolean bl2 = direction == Direction.NORTH || direction == Direction.EAST;
        int n = enq.eob(itemFrameEntity2.getAttachedBlockPos(), bl);
        List list = world.getEntitiesByClass(ItemFrameEntity.class, itemFrameEntity2.getBoundingBox().expand(16.0), itemFrameEntity -> itemFrameEntity.getHorizontalFacing() == direction && enq.eob(itemFrameEntity.getAttachedBlockPos(), bl) == n && itemFrameEntity.getHeldItemStack().getItem() instanceof FilledMapItem);
        List<ItemFrameEntity> list2 = enq.eoa(list, itemFrameEntity2);
        if (list2.isEmpty()) {
            return null;
        }
        int n2 = Integer.MAX_VALUE;
        int n3 = Integer.MIN_VALUE;
        int n4 = Integer.MAX_VALUE;
        int n5 = Integer.MIN_VALUE;
        HashSet<BlockPos> hashSet = new HashSet<BlockPos>();
        for (ItemFrameEntity itemFrameEntity3 : list2) {
            object = itemFrameEntity3.getAttachedBlockPos();
            if (!hashSet.add((BlockPos)object)) {
                return null;
            }
            int n6 = bl ? object.getX() : object.getZ();
            n2 = Math.min(n2, n6);
            n3 = Math.max(n3, n6);
            n4 = Math.min(n4, object.getY());
            n5 = Math.max(n5, object.getY());
        }
        int n7 = n3 - n2 + 1;
        int n8 = n5 - n4 + 1;
        if (n7 > 16 || n8 > 16 || list2.size() < 2 || list2.size() * 2 < n7 * n8) {
            return null;
        }
        object = new BufferedImage(n7 * 128, n8 * 128, 2);
        Graphics2D graphics2D = ((BufferedImage)object).createGraphics();
        try {
            for (ItemFrameEntity itemFrameEntity4 : list2) {
                int n9;
                BufferedImage bufferedImage;
                MapState mapState = FilledMapItem.getMapState((ItemStack)itemFrameEntity4.getHeldItemStack(), (World)world);
                if (mapState == null || mapState.colors == null || mapState.colors.length != 16384) {
                    bufferedImage = null;
                    return bufferedImage;
                }
                bufferedImage = new BufferedImage(128, 128, 2);
                boolean bl3 = false;
                for (int i = 0; i < mapState.colors.length; ++i) {
                    n9 = mapState.colors[i] & 0xFF;
                    bl3 |= n9 >= 4;
                    bufferedImage.setRGB(i % 128, i / 128, n9 < 4 ? 0 : MapColor.getRenderColor((int)n9));
                }
                if (!bl3) {
                    BufferedImage bufferedImage2 = null;
                    return bufferedImage2;
                }
                BlockPos blockPos = itemFrameEntity4.getAttachedBlockPos();
                n9 = bl ? blockPos.getX() : blockPos.getZ();
                int n10 = (bl2 ? n3 - n9 : n9 - n2) * 128;
                int n11 = (n5 - blockPos.getY()) * 128;
                AffineTransform affineTransform = AffineTransform.getTranslateInstance(n10, n11);
                affineTransform.rotate((double)(itemFrameEntity4.getRotation() & 3) * Math.PI / 2.0, 64.0, 64.0);
                graphics2D.drawImage(bufferedImage, affineTransform, null);
            }
        }
        finally {
            graphics2D.dispose();
        }
        return object;
    }

    public static BufferedImage captureNearest(World world, Entity entity) {
        for (List<ItemFrameEntity> list : enq.findWalls(world, entity, 24.0)) {
            BufferedImage bufferedImage = enq.capture(list.stream().min(Comparator.comparingDouble(itemFrameEntity -> itemFrameEntity.squaredDistanceTo(entity))).orElseThrow());
            if (bufferedImage == null || enq.isShuffled(bufferedImage)) continue;
            return bufferedImage;
        }
        return null;
    }

    public static List<List<ItemFrameEntity>> findWalls(World world, Entity entity, double d) {
        Vec3d vec3d = entity.getEyePos();
        List list2 = world.getEntitiesByClass(ItemFrameEntity.class, entity.getBoundingBox().expand(d), itemFrameEntity -> itemFrameEntity.getHorizontalFacing().getAxis() != Direction.Axis.Y && itemFrameEntity.getHeldItemStack().getItem() instanceof FilledMapItem && enq.enx(itemFrameEntity, vec3d));
        Vec3d vec3d2 = entity.getRotationVec(1.0f);
        List<List<ItemFrameEntity>> list3 = enq.enz(list2);
        list3.removeIf(list -> list.size() < 2);
        list3.sort(Comparator.comparingInt(list -> list.size() >= 4 ? 0 : 1).thenComparingDouble(list -> enq.eny(list, vec3d, vec3d2)));
        return list3;
    }

    public static double seamRatio(int[] nArray, int n, int n2) {
        double d = 0.0;
        double d2 = 0.0;
        long l = 0L;
        long l2 = 0L;
        for (int i = 0; i < n2; ++i) {
            for (int j = 0; j < n; ++j) {
                double d3;
                int n3 = nArray[i * n + j];
                if (n3 >>> 24 == 0) continue;
                if (j + 1 < n && nArray[i * n + j + 1] >>> 24 != 0) {
                    d3 = enq.enw(n3, nArray[i * n + j + 1]);
                    if ((j + 1) % 128 == 0) {
                        d += d3;
                        ++l;
                    } else {
                        d2 += d3;
                        ++l2;
                    }
                }
                if (i + 1 >= n2 || nArray[(i + 1) * n + j] >>> 24 == 0) continue;
                d3 = enq.enw(n3, nArray[(i + 1) * n + j]);
                if ((i + 1) % 128 == 0) {
                    d += d3;
                    ++l;
                    continue;
                }
                d2 += d3;
                ++l2;
            }
        }
        if (l == 0L || l2 == 0L || d2 <= 0.0) {
            return 0.0;
        }
        return d / (double)l / (d2 / (double)l2);
    }

    public static boolean isShuffled(BufferedImage bufferedImage) {
        int n;
        int n2 = bufferedImage.getWidth();
        return enq.seamRatio(bufferedImage.getRGB(0, 0, n2, n = bufferedImage.getHeight(), null, 0, n2), n2, n) > 2.0;
    }

    private static double enw(int n, int n2) {
        return (double)(Math.abs((n >> 16 & 0xFF) - (n2 >> 16 & 0xFF)) + Math.abs((n >> 8 & 0xFF) - (n2 >> 8 & 0xFF)) + Math.abs((n & 0xFF) - (n2 & 0xFF))) / 3.0;
    }

    private static boolean enx(ItemFrameEntity itemFrameEntity, Vec3d vec3d) {
        Direction direction = itemFrameEntity.getHorizontalFacing();
        Vec3d vec3d2 = vec3d.subtract(itemFrameEntity.getEntityPos());
        return vec3d2.x * (double)direction.getOffsetX() + vec3d2.z * (double)direction.getOffsetZ() > 0.25;
    }

    private static double eny(List<ItemFrameEntity> list, Vec3d vec3d, Vec3d vec3d2) {
        double d = Double.MAX_VALUE;
        Vec3d vec3d3 = Vec3d.ZERO;
        for (ItemFrameEntity itemFrameEntity : list) {
            d = Math.min(d, itemFrameEntity.getEntityPos().distanceTo(vec3d));
            vec3d3 = vec3d3.add(itemFrameEntity.getEntityPos());
        }
        Vec3d vec3d4 = vec3d3.multiply(1.0 / (double)list.size()).subtract(vec3d).normalize();
        return d * (1.5 - 0.5 * vec3d4.dotProduct(vec3d2));
    }

    private static List<List<ItemFrameEntity>> enz(List<ItemFrameEntity> list) {
        HashMap<Long, List> hashMap = new HashMap<Long, List>();
        for (ItemFrameEntity object : list) {
            boolean list2 = object.getHorizontalFacing().getAxis() == Direction.Axis.Z;
            long arrayList2 = (long)object.getHorizontalFacing().ordinal() << 32 | (long)enq.eob(object.getAttachedBlockPos(), list2) & 0xFFFFFFFFL;
            hashMap.computeIfAbsent(arrayList2, l -> new ArrayList()).add(object);
        }
        ArrayList arrayList = new ArrayList();
        for (List list2 : hashMap.values()) {
            ArrayList<ItemFrameEntity> arrayList2 = new ArrayList<ItemFrameEntity>(list2);
            while (!arrayList2.isEmpty()) {
                List<ItemFrameEntity> list3 = enq.eoa(arrayList2, (ItemFrameEntity)arrayList2.get(0));
                arrayList2.removeAll(list3);
                arrayList.add(list3);
            }
        }
        return arrayList;
    }

    private static List<ItemFrameEntity> eoa(List<ItemFrameEntity> list, ItemFrameEntity itemFrameEntity) {
        boolean bl = itemFrameEntity.getHorizontalFacing().getAxis() == Direction.Axis.Z;
        ArrayList<ItemFrameEntity> arrayList = new ArrayList<ItemFrameEntity>();
        HashSet<ItemFrameEntity> hashSet = new HashSet<ItemFrameEntity>();
        ArrayDeque<ItemFrameEntity> arrayDeque = new ArrayDeque<ItemFrameEntity>();
        arrayDeque.add(itemFrameEntity);
        hashSet.add(itemFrameEntity);
        while (!arrayDeque.isEmpty()) {
            ItemFrameEntity itemFrameEntity2 = (ItemFrameEntity)arrayDeque.poll();
            arrayList.add(itemFrameEntity2);
            BlockPos blockPos = itemFrameEntity2.getAttachedBlockPos();
            int n = bl ? blockPos.getX() : blockPos.getZ();
            for (ItemFrameEntity itemFrameEntity3 : list) {
                if (hashSet.contains(itemFrameEntity3)) continue;
                BlockPos blockPos2 = itemFrameEntity3.getAttachedBlockPos();
                int n2 = Math.abs((bl ? blockPos2.getX() : blockPos2.getZ()) - n);
                if (n2 > 1 || Math.abs(blockPos2.getY() - blockPos.getY()) > 1) continue;
                hashSet.add(itemFrameEntity3);
                arrayDeque.add(itemFrameEntity3);
            }
        }
        return arrayList;
    }

    public static byte[] encodePng(BufferedImage bufferedImage) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!ImageIO.write((RenderedImage)bufferedImage, a.b("\u0938\u7097\ufa4d", -963507893), byteArrayOutputStream)) {
            throw new IOException(a.c(1744907341, "\u2c0a\u55a5\udf7f\u4169\ucafb\u4c41\uf61f\u7fe2\ue1b6\u6b06\uecc2\u16e1\u9863\u01c9\u8b95\u0d73\ub72b\u38f2\ua244\u2418\uadec\ud7b3\u5909"));
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static int eob(BlockPos blockPos, boolean bl) {
        return bl ? blockPos.getZ() : blockPos.getX();
    }

    private static /* synthetic */ int if(int n, int n2) {
        return n + n2 + 959484858;
    }

    private static /* synthetic */ int ig(int n, int n2) {
        return enq.if(n, n2) + n;
    }

    private static /* synthetic */ int ih(int n, int n2) {
        return enq.if(n, n2) * n2;
    }
}

