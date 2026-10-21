/*
 * Decompiled with CFR 0.152.
 */
package a;

public final class Waypoint {
    public String name;
    public double x;
    public double y;
    public double z;
    public int color;
    public boolean ownColor;
    public String world;
    public String dimension;
    public boolean visible = true;
    public long created;
    private static /* synthetic */ int wkr;
    private static /* synthetic */ int wks;

    public Waypoint() {
    }

    public Waypoint(String string, double d, double d2, double d3, int n, String string2, String string3) {
        this.name = string;
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.color = n;
        this.world = string2;
        this.dimension = string3;
        this.created = System.currentTimeMillis();
    }

    public double cx() {
        return Math.floor(this.x) + 0.5;
    }

    public double cy() {
        return Math.floor(this.y) + 0.5;
    }

    public double cz() {
        return Math.floor(this.z) + 0.5;
    }

    private static /* synthetic */ int dre(int n, int n2) {
        return n ^ n2 ^ 0x1C6C1EB4;
    }

    private static /* synthetic */ int drf(int n, int n2) {
        return n * n2 + 1785509527;
    }

    private static /* synthetic */ int drg(int n, int n2) {
        return n - n2 + -948174876;
    }
}

